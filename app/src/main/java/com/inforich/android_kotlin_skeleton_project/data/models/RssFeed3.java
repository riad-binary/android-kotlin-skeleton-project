package com.inforich.android_kotlin_skeleton_project.data.models;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.List;

@Root(name = "feed", strict = false)
public class RssFeed3 {
    @NonNull
    @NotNull
    @Override
    public String toString() {
        return super.toString();
    }


    //    @Element(name = "title")
//    public String title;

//    @Element(name = "channel")
//    public Channel channel;

//    public class Channel {
//
//        @ElementList
//        public List<Article> articles;
//    }


//    @Element(name = "item")
//    public class Article {
//
//        @Element(name = "title")
//        private String title;
//
//        @Element(name = "link")
//        private String link;
//
//        @Element(name = "description")
//        private String description;
//
//        @Element(name = "Enclosure")
//        private Enclosure enclosure;
//
//        @Element(name = "guid")
//        private String guid;
//
//        @Element(name = "pubDate")
//        private String pubDate;
//
//        @Element(name = "source")
//        private Source source;
//
//        public class Enclosure {
//
//            @Attribute(name = "url")
//            private String url;
//
//            @Attribute(name = "length")
//            private long length;
//
//            @Attribute(name = "type")
//            private String type;
//        }
//
//        public class Source {
//
//            @Attribute(name = "url")
//            private String url;
//
//            @Text
//            private String text;
//        }
//    }

}



