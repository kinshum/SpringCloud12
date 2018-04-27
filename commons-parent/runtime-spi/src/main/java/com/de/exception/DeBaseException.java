package com.de.exception;

public class DeBaseException extends DeException {

	/**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 8970523354415436014L;

	private DeBaseException(String message) {
        super(message);
    }
	public DeBaseException(ErrorBaseEnum err) {
        super(err.getDescription(),err.getValue());
    }
	public static enum ErrorBaseEnum {
	    ERR_EXCEPTION(BASE_SERVICE, "未知异常错误"),
        ERR_BASE_FAIL(BASE_SERVICE +1, "操作失败"),
	    ERR_BASE_FAIL_INSERT(BASE_SERVICE +2, "保存失败"),
	    ERR_BASE_FAIL_DELETE(BASE_SERVICE +3, "删除失败"),
	    ERR_BASE_FAIL_UPDATE(BASE_SERVICE +4, "更新失败"),
	    ERR_BASE_FAIL_SELECT(BASE_SERVICE +5, "查询失败"),
	    ERR_BASE_FAIL_SHORTLINKS(BASE_SERVICE +6, "短连接未配置"),
	    ERR_BASE_FAIL_IDSN_TYPE_ISNULL(BASE_SERVICE +7, "获取idSn时type值不正确"),
	    ERR_BASE_ISNULL_ID(BASE_SERVICE +101, "ID不能为空"),
	    ERR_BASE_ISNULL_CONTINENT(BASE_SERVICE +102, "大洲不能为空"),
	    ERR_BASE_ISNULL_COUNTRY(BASE_SERVICE +103, "国家不能为空"),
	    ERR_BASE_ISNULL_COUNTRY_IMG(BASE_SERVICE +104, "签证国家图片不能为空"),
	    ERR_BASE_ISNULL_PRODUCT_IMG(BASE_SERVICE +105, "产品图片不能为空"),
	    ERR_BASE_ISNULL_RECOMMEND(BASE_SERVICE +106, "推荐状态不能为空"),
	    ERR_BASE_ISNULL_SHOW(BASE_SERVICE +107, "推荐状态不能为空"),
	    ERR_BASE_ISNULL_RECEIVEID(BASE_SERVICE +108, "收信人ID不能为空"),
	    ERR_BASE_ISNULL_VERSIONNUM(BASE_SERVICE +109, "版本号不能为空"),
	    ERR_BASE_ISNULL_PLATFORM(BASE_SERVICE +110, "升级地址不能为空"),
	    ERR_BASE_ISNULL_PACKAGESIZE(BASE_SERVICE +111, "安装包大小不能为空"),
	    ERR_BASE_ISNULL_FORCEUPGRADE(BASE_SERVICE +112, "请选择是否强制升级"),
	    ERR_BASE_ISNULL_PROMPTUPGRADE(BASE_SERVICE +113, "请选择是否提示升级"),
	    ERR_BASE_ISNULL_UPGRADECONTENT(BASE_SERVICE +114, "升级内容不能为空"),
	    ERR_BASE_ISNULL_CREATEBY(BASE_SERVICE +115, "创建者不能为空"),
	    ERR_BASE_ISNULL_UPDATEBY(BASE_SERVICE +116, "修改者不能为空"),
		ERR_BASE_ISNULL_KEYWORD(BASE_SERVICE +117,"关键字不能为空"),
	    ERR_BASE_NOT_FOUND_COUNTRY(BASE_SERVICE +201, "签证国家不存在"),
	    ERR_BASE_NOT_FOUND_VERSION(BASE_SERVICE +202, "版本不存在"),
	    ERR_BASE_EXISTS_COUNTRY(BASE_SERVICE +301, "国家已存在"),
	    ERR_BASE_EXISTS_VERSIONNUM(BASE_SERVICE +302, "当前平台已存在相同版本"),
	    ERR_BASE_FORMAT_VERSIONNUM(BASE_SERVICE +401, "版本号格式不正确"),
	    ERR_BASE_ELSE_VERSION_PUBLISHED(BASE_SERVICE +501, "当前版本已发布"),
	    ERR_BASE_ELSE_VERSIONNUM(BASE_SERVICE +502, "请把版本号修改为正式版本号格式再发布"),
	    ERR_BASE_ELSE_NOTNEW_VERSIONNUM(BASE_SERVICE +502, "发布的版本不是最新版本"),
	    ERR_BASE_ELSE_MORE_PUBLISHED(BASE_SERVICE +503, "同一平台存在多个已发布版本"),
	    ERR_BASE_ELSE_LEAST_APPF_NUM(BASE_SERVICE +504, "至少要生成一个F码"),
	    ERR_BASE_ELSE_MOST_APPF_NUM(BASE_SERVICE +505, "单次最大生成1000个F码"),
	    ERR_BASE_ELSE_MORE_APPF_NUM(BASE_SERVICE +506, "系统中F码过多,请删除后再生成"),
		ERR_BASE_FAIL_CARD_TYPE_ISNULL(BASE_SERVICE +601, "手机号或身份证号不正常");
	    
        private int value;
        private String description;

        private ErrorBaseEnum(int value, String description) {
            this.value = value;
            this.description = description;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
    }

}
