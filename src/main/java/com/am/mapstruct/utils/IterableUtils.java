package com.am.mapstruct.utils;

import java.util.List;

public class IterableUtils {

    @OnlyFirstElement
    public <T> T first( List<T> in ) {
        if ( in != null && !in.isEmpty() ) {
            return in.get( 0 );
        }
        else {
            return null;
        }
    }

}
