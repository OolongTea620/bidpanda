package com.panda.back.domain.job.service;

import com.panda.back.domain.item.entity.Item;
import com.panda.back.domain.job.dto.ItemCUDEvent;
import com.panda.back.domain.job.dto.JobClientRequestDto;
import com.panda.back.domain.job.dto.component.Job;
import com.panda.back.domain.job.dto.component.Schedule;
import com.panda.back.domain.job.entity.CronJob;
import com.panda.back.domain.job.repository.CronJobRepository;
import com.panda.back.global.exception.CustomException;
import com.panda.back.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class CronJobService {
    private final WebClient webClient;
    private final CronJobRepository cronJobRepository;

//    @Value("${api.key.cron-job}")
    public String CRONJOB_API_KEY = "here cron-job api key";

//    @Value("${bidpanda.domain}")
    public String DOMAIN_URL = "this is bidpanda domain";
    private static final String HOOK_RECEIVE_URI = "/api/items/%s/close-alarm";
    private static final String HOOK_REMIND_URI="/api/items/%s/remind-alarm";

    @Transactional
    public void itemCUDEvent(ItemCUDEvent itemEvent) {
        switch (itemEvent.getType()) {
            case create -> {
                this.registerAuctionEndTimeJob(itemEvent.getItem());
            }
            case update -> {
                this.requestUpdateCronJob(itemEvent.getItem());
            }
            case delete -> {
                CronJob job = cronJobRepository.findByItem(itemEvent.getItem())
                        .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_JOB));
                Long jobId = job.getJobId();
                // api 요청
                this.requestDeleteCronJob(jobId);
                cronJobRepository.delete(job);
            }
            case remind -> {
                Long jobId = this.requestRemindCronJob(itemEvent.getItem());
            }
        }
    }

    private void registerAuctionEndTimeJob(Item item){
        Long jobId = requestCreateCronJob(item);
        cronJobRepository.save(new CronJob(item, jobId));
    }

    private Long requestCreateCronJob(Item item) {
        String eventReceiveUrl = String.format((DOMAIN_URL + HOOK_RECEIVE_URI),item.getId().toString());
        Schedule schedule = new Schedule(item.getAuctionEndTime());
        Job job = new Job(eventReceiveUrl,item.getTitle(), schedule);
        Map response = webClient
                .put()
                .uri("/jobs")
                .headers(httpHeaders -> {
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    httpHeaders.setBearerAuth(CRONJOB_API_KEY);
                })
                .bodyValue(new JobClientRequestDto(job))
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        log.info("{} request job to cron-job.org", item.getTitle());
        return Long.parseLong(response.get("jobId").toString());
    }

    private void requestUpdateCronJob(Item item){
        CronJob cronJob = cronJobRepository.findByItem(item)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_JOB));

        String eventReceiveUrl = String.format((DOMAIN_URL + HOOK_RECEIVE_URI),item.getId().toString());
        Schedule schedule = new Schedule(item.getAuctionEndTime());
        Job job = new Job(eventReceiveUrl,item.getTitle(), schedule);

        webClient
                .patch()
                .uri("/jobs/" + cronJob.getJobId())
                .headers(httpHeaders -> {
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    httpHeaders.setBearerAuth(CRONJOB_API_KEY);
                })
                .bodyValue(new JobClientRequestDto(job))
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
    private void requestDeleteCronJob(Long jobId) {
        webClient
                .delete()
                .uri("/jobs/" + jobId)
                .headers(httpHeaders -> {
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    httpHeaders.setBearerAuth(CRONJOB_API_KEY);
                })
                .retrieve();
        log.info("cron-job {} : is deleted", jobId);
    }

    private Long requestRemindCronJob(Item item) {
        String eventReceiveUrl = String.format((DOMAIN_URL + HOOK_REMIND_URI),item.getId().toString());
        Schedule schedule = new Schedule(item.getAuctionEndTime().minusMinutes(30));
        Job job = new Job(eventReceiveUrl, "remind 30 before : " + item.getTitle(), schedule);

        Map response = webClient
                .put()
                .uri("/jobs")
                .headers(httpHeaders -> {
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    httpHeaders.setBearerAuth(CRONJOB_API_KEY);
                })
                .bodyValue(new JobClientRequestDto(job))
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        log.info("{} request remind job to cron-job.org", item.getTitle());
        return Long.parseLong(response.get("jobId").toString());
    }

}