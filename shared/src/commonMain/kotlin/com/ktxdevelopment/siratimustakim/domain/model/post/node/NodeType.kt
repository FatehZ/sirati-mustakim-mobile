package com.ktxdevelopment.siratimustakim.domain.model.post.node

enum class NodeType {
    IMG,     // base64 code of image
    URL,     // web link of external page
    IMGURL,  // url of an image on web
    TXT,     // plain text
    AYE,     // id of ayeth from Quran,
    POSTID,  // postId of another post
}
