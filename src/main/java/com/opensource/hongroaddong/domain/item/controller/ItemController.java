package com.opensource.hongroaddong.domain.item.controller;

import com.opensource.hongroaddong.domain.common.ResponseDto;
import com.opensource.hongroaddong.domain.item.dto.request.ItemUploadRequestDto;
import com.opensource.hongroaddong.domain.item.dto.response.ItemResponseDto;
import com.opensource.hongroaddong.domain.item.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
@Tag(name = "🚗Item", description = "Item API")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/upload")
    @Operation(summary = "하차 후 편집하기")
    public ResponseEntity<ItemResponseDto> uploadItem(@Valid @RequestBody ItemUploadRequestDto requestDto) {
        var response = itemService.uploadItem(requestDto);
        return ResponseDto.created(response);
    }

}
