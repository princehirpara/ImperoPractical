package com.recycle.task.models.products

class ProductRequestModel {

    var PageIndex:Int = 0
    var SubCategoryId:Int = 0

    constructor(PageIndex: Int, SubCategoryId: Int) {
        this.PageIndex = PageIndex
        this.SubCategoryId = SubCategoryId
    }
}