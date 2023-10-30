package com.Mukesh.BloggingPlatformAPI.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private String postTitle;
    private String postContent;
}
