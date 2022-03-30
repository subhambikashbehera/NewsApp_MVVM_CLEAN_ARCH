package com.onlineexam.newsapp.data.db

import androidx.room.TypeConverter
import com.onlineexam.newsapp.data.model.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source):String{
           return source.name
    }
    @TypeConverter
    fun toSource(name:String):Source{
        return Source(name,name)
    }
}
