package com.inforich.android_kotlin_skeleton_project.data.models

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "feed", strict = false)
class RssFeed {
    @Element
    var entry: RssEntry? = null
    override fun toString(): String {
        return "RssFeed [entry=$entry]"
    }
}


@Root(name = "entry", strict = false)
class RssEntry {
    @Element
    private val title: String? = null

//    @Element
//    private val image: RssImage? = null

//    @ElementList(inline = true, required = false)
//    var item: List<RssItem>? = null
//    override fun toString(): String {
//        return "Channel [image=$image, item=$item]"
//    }
}

//@Root(name = "image", strict = false)
//class RssImage {
//    @Element
//    private val url: String? = null
//
//    @Element
//    private val width: String? = null
//
//    @Element
//    private val height: String? = null
//    override fun toString(): String {
//        return "RssImage [url=$url, width=$width, height=$height]"
//    }
//}
//
//@Root(name = "item", strict = false)
//class RssItem {
//    @Element
//    private val title: String? = null
//
//    @Element
//    private val link: String? = null
//
//    @Element
//    private val pubDate: String? = null
//
//    @Element
//    private val description: String? = null
//    override fun toString(): String {
//        return ("RssItem [title=" + title + ", link=" + link + ", pubDate=" + pubDate
//                + ", description=" + description + "]")
//    }
//}