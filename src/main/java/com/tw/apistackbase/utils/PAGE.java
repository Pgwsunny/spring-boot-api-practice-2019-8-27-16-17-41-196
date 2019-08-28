package com.tw.apistackbase.utils;

import java.util.List;

public class PAGE {
	/**
     * list分页展示
	 * @param <T>
     */
    public  static <T> List<T> getPageList(int page, int pageSize, List<T> list) {
        int totalCount = list.size();
        page = page - 1;
        int fromIndex = page * pageSize;

        int toIndex = ((page + 1) * pageSize);
        if (toIndex > totalCount) {
            toIndex = totalCount;
        }
        return list.subList(fromIndex, toIndex);
    }

}
