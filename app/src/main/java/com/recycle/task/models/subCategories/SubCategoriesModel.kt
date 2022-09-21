package com.recycle.task.models.subCategories

class SubCategoriesModel {

    var CategoryId : Int = 0
    var PageIndex : Int = 0

    constructor(CategoryId: Int, PageIndex: Int) {
        this.CategoryId = CategoryId
        this.PageIndex = PageIndex
    }
}