package com.opensource.hongroaddong.domain.item.service;

import com.opensource.hongroaddong.domain.car.entity.Car;
import com.opensource.hongroaddong.domain.car.service.CarService;
import com.opensource.hongroaddong.domain.item.dto.request.ItemUploadRequestDto;
import com.opensource.hongroaddong.domain.item.dto.response.ItemResponseDto;
import com.opensource.hongroaddong.domain.item.entity.Item;
import com.opensource.hongroaddong.domain.item.repository.ItemRepository;
import com.opensource.hongroaddong.domain.member.entity.Member;
import com.opensource.hongroaddong.domain.member.service.MemberService;
import com.opensource.hongroaddong.domain.video.service.VideoService;
import com.opensource.hongroaddong.global.error.dto.ErrorCode;
import com.opensource.hongroaddong.global.error.exception.common.BusinessException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final MemberService memberService;
    private final CarService carService;
    private final VideoService videoService;
    private final ItemRepository itemRepository;

    @Transactional
    public ItemResponseDto uploadItem(ItemUploadRequestDto requestDto) {
        var comment = requestDto.getComment();
        var drivingDegree = requestDto.getDrivingDegree();
        var member = memberService.findMember(requestDto.getMemberId());
        var car = carService.findCar(requestDto.getCarNumber());
        var video = videoService.findVideo(requestDto.getVideoId());

        checkIsSameCarMemberWithMember(car, member);

        memberService.updateDrivingDegree(car.getMember(), drivingDegree);

        var item = Item.builder()
                .comment(comment)
                .drivingDegree(drivingDegree)
                .member(member)
                .car(car)
                .video(video)
                .build();

        var saved = itemRepository.save(item);
        return ItemResponseDto.from(saved);
    }

    private void checkIsSameCarMemberWithMember(Car car, Member member) {
        if (car.ownerEquals(member)) {
            throw new BusinessException(ErrorCode.CAR_MEMBER_AND_MEMBER_CANNOT_MATCH);
        }
    }

}
