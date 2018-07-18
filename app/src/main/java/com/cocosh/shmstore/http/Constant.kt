package com.cocosh.shmstore.http

/**
 * Created by lmg on 2017/10/12.
 */
object Constant {
    var DEBUG = false
    val SUCCESS = "0000"
    val MAX_SECONDS = 20
    val DEVICE_ID = "10010"
    val DEVICE_TYPE = "0"
    val ID_TYPE = arrayOf("身份证", "军官证", "护照")
    val SEX = arrayOf("男", "女", "保密")
    val PUBLISH_TYPE = arrayOf("文字", "图片", "小视频")
    val DISMISS_CIRCLE = arrayOf("解散小圈", "转让圈主")
    val BACK_RING = arrayOf("退出圈子", "取消")
    val SEARCH_PACKET = "search_packet"
    val SEND_ADD_FRIEND_MSG_SUCCESS = "send_add_msg_success"
    val ADD_EXP = "add_exp"
    val EXIT = "exit"
    val USERFRIENDS = "userfriends"
    val ADD_FRIEND_SUCCESS = "add_friend_success"
    val ADD_GROUP = "add_group"
    val FIRST_RULE = "first_rule"
    val FIRST_NOTICE = "first_notice"
    val OPEN_PACKET = "pen_packet"
    val AGREE_LICENSE = "agree_license"
    val LOCATION_UPDATE = "location_update"
    val WEATHER_UPDATE = "weather_update"
    val CALL = "call"
    val LAST_LOGIN = "last_login"
    val PUBLISH_ADDRESS = "publish_address"
    val PUBLISH_LATITUDE = "latitude"
    val PUBLISH_LONGITUDE = "longitude"
    val PUBLISH_DYNAMIC_SUCCESS = "publish_dynamic_success"
    val REFRESH_SALES = "refresh_sales"
    val SALE_TYPE_INDEX = "sale_type_index"
    val REFRESH_WEB = "refresh_web"
    val IS_LOGIN = "is_login"
    val SEND_PACKET = "send_packet"
    val AREA_RANGE = intArrayOf(100, 500, 1000)
    val DELETEMEMBER_SUCCESS = "delete_member_success"
    val SLIENT_MEMBER_SUCCESS = "slient_member_success"
    val DELETE_IMAGE_SUCCESS = "delete_img_success"
    val CIRCLE_CREATE_SUCCESS = "circle_create_success"
    val CIRCLE_SAVE_SUCCESS = "circle_save_success"
    val CIRCLE_DELETE_SUCCESS = "circle_delete_success"
    val JOIN_CIRCLE_SUCCESS = "join_circle_success"
    val CONFIRM_SUCCESS = "is_need_confirm"
    val ADD_MEMBER_SUCCESS = "add_member_success"

    val PERMISSION_REQUEST_CAMERA = 1  //相机权限

    /**
     * 0011 指的是两个人同时登录token失效  app去登陆页面
     */
    val LOGING_DEVICE_CHANGE = "0011"
    val LOGING_DEVICE_ELSE = "0002"

    /**
     * token 时间长了过期了
     */
    val LAPSED = "0003"

    //普通用户
    val USER_NORMAL = "0"
    //商家用户(特卖汇)
    val USER_SHOP = "1"

    val DESTORY_CIRCLE = "destory_circle"
    val REFRESH_NOTIFICATION = "refresh_notification"
    val TALK_TYPE = "talk_type"

    //图片规格
//    val IMAGE_SMALL = "?imageView2/1/w/" + DisplayUtil.dip2px(App.getInstance(), 45) + "/h/" + DisplayUtil.dip2px(App.getInstance(), 45)
//    val IMAGE_MIDDLE = "?imageView2/1/w/" + DisplayUtil.dip2px(App.getInstance(), 90) + "/h/" + DisplayUtil.dip2px(App.getInstance(), 90)
    val IMAGE_VIDEO = "?vframe/png/offset/1/"

    val FIRST_OPEN_PAY_CODE = "first_open_pay_code"
    val DELETE_FRIEND_SUCCESS = "delete_friend_success"
    val CHANGE_BLACK_SUCCESS = "change_black_success"
    val REFRESH_MESSAGE = "refresh_message"
    val TRANSFER_CIRCLE_SUCCESS = "transfer_circle_success"
    val SEND_IDCARD = "send_idcard"
    val REFRESH_SHOP_MESSAGE = "refresh_shop_message"

    val IS_READ_DEL = "is_read_del"
    val IS_GET_DEL = "is_get_del"
    val QUITE_CIRCLE_SUCCESS = "quite_circle_success"
    val SELECT_CITY = "select_city"
    val SEARCH_CITY = "search_city"

    //    val SELECT_DETAIL = ApiManager.BASE_URL + "advert/getPositionU_advert_goods?"
    val LOAD = "000"

    val IS_SHOPChCAT = "is_shopchcat"
    val AUTHOR = "is_shopchcat"

    //登录
    val LOGIN = "member/login"

    //财富明细
    val MONEY_DETAIL = "account/getUserCashRecords"
    //财富明细获取月份
    val GET_MONTH = "member/getUserCreateTimeToNow"
    val NEWS_DETAIL_TYPE = "news_detail_type"

    //获取银行卡列表
    val GET_BANK_CARD_LIST = "member/bankCard/getBankCardList"
    //提现withdraw/apply
    val WITHDRAW = "member/withdraw/apply"
    //添加银行卡 bankCard/insertNewBank
    val INSERTNEWBANK = "member/bankCard/insertNewBank"
    //根据卡号获取银行卡信息
    val GETBANKCARDINFO = "account/bankcard/getBankcardInfo"
    //合伙人收益 member/getMemberBonus
    val GETMEMBERBONUS = "member/getMemberBonus"
    //财富明细account/getUserCashRecords
    val GETUSERCASHRECORDS = "account/getUserCashRecords"

    //新闻头条 search
    val NEWS_SEARCH_API = "headline/searchArticler"
    //新闻头条 issue
    val NEWS_ISSUE_API = "headline/getUserCate"
    //新闻头条 关注
    val NEWS_CANCEL_OR_FOLLOW_API = "headline/addOrCancelFollow"
    //新闻头条 赞
    val NEWS_ZAN_OR_CANCEL = "headline/addOrCancelZan"
    //新闻头条 详情页
    val NEWS_DETAIL_API = "headline/getArticlerResource"

    //新闻头条 评论
    val NEWS_COMMENT_PUSH_API = "headline/addMessage"
    val NEWS_COMMENT_PULL_API = "headline/getMessageByDateTime"

    //用户分类
    val GET_USER_CATE = "headline/getUserCate"

    //新闻列表
    val CATE_ARTICLE_TITLE = "headline/getCateArticleTitle"

    //所有分类
    val GET_CATE = "headline/getCateArticle"

    //更改用户分类
    val UPDATE_USER_CATE = "headline/updateUserCate"

    //图片上传
    val UPDATE_IMAGE = "common/uploadPic"

    val AD = "advert/getPositionU_advert"
    //新闻报 喜欢、不喜欢headline/updateUserLikeOrDislike
    val UPDATEUSERLIKEORDISLIKE = "headline/updateUserLikeOrDislike"
    //删除银行卡 member/bankCard/deleteBankCard
    val DELETEBANKCARD = "member/bankCard/deleteBankCard"
}