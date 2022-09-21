package com.recycle.task.models.categories

class CategoriesRequestModel {

    var CategoryId :Int = 0
    var DeviceManufacturer:String = ""
    var DeviceModel:String = ""
    var DeviceToken:String = ""
    var PageIndex:Int = 0

    constructor()

    constructor(
        CategoryId: Int,
        DeviceManufacturer: String,
        DeviceModel: String,
        DeviceToken: String,
        PageIndex: Int
    ) {
        this.CategoryId = CategoryId
        this.DeviceManufacturer = DeviceManufacturer
        this.DeviceModel = DeviceModel
        this.DeviceToken = DeviceToken
        this.PageIndex = PageIndex
    }


}