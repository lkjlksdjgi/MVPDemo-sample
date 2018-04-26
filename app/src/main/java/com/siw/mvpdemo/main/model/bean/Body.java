package com.siw.mvpdemo.main.model.bean;


import java.util.List;

public class Body {
    @Override
    public String toString() {
        return "Body{" +
                "cjwtH5url='" + cjwtH5url + '\'' +
                ", jqH5url='" + jqH5url + '\'' +
                ", jtH5url='" + jtH5url + '\'' +
                ", newFlag='" + newFlag + '\'' +
                ", cjwtList=" + cjwtList +
                ", jqList=" + jqList +
                ", jtList=" + jtList +
                '}';
    }

    /**
     * cjwtH5url : http://m.zhcw.com/khd/k3xhzs/gl/cjwt/index.shtml
     * cjwtList : [{"logoFile":"","summary":"邀请码是部分推广活动使用的，非必填项。","title":"邀请码是什么？","url":"http://m.zhcw.com/khd/k3xhzs/gl/cjwt/lb/13417569.shtml"},{"logoFile":"","summary":"提现是指之前邀新返利活动获得的佣金进行提取。","title":"提现是什么？","url":"http://m.zhcw.com/khd/k3xhzs/gl/cjwt/lb/13417580.shtml"},{"logoFile":"","summary":"点击中彩网首页中间 -\u201c大数据\u201d选择快3界面-底端点击\u201c攻略\u201d。","title":"看不懂趋势图怎么办？","url":"http://m.zhcw.com/khd/k3xhzs/gl/cjwt/lb/13417601.shtml"},{"logoFile":"","summary":"参加过之前包月立减活动的用户，不可参与本次1个月 VIP 的立减活动，购买 3 个月和 1 年的 VIP 优惠活动可以参与。 3月 23 日前已经购买过套餐服务的用户，升级至新版 5.1.0 版客户端","title":"以前买过会员服务，新活动怎么享受？","url":"http://m.zhcw.com/khd/k3xhzs/gl/cjwt/lb/16308682.shtml"}]
     * jqH5url : http://m.zhcw.com/khd/k3xhzs/gl/jq/index.shtml
     * jqList : [{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/04/26/1083843.jpg","summary":"对于你选中的号码，你是否了解号码的历史趋势，是否对号码很有把握呢？ 小编为大家推荐个强大的功能→快3选号助手的\u201c号码验证\u201d功能!通过此功能我们可以查看号码趋势和遗漏情况，判断号码近期走势，对自己的号码更有把握哦~ 这个强大的功能怎么使用呢？ 第一步：点击\u201c号码验证\u201d进入到号码验证界面。","title":"号码验证分析，看这篇就够！","url":"http://m.zhcw.com/khd/k3xhzs/gl/jq/lb/16861944.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/04/25/1083462.jpg","summary":"快3选号助手速查表","title":"快3选号助手速查表","url":"http://data.zhcw.com/h5/app/sucha.php?action=kssc"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/04/19/1082196.png","summary":"王者荣耀被称作中国游戏行业 有史以来最严格的防沉迷措施 那么，各位新媒体的小编们 难道彩票不该\u201c防沉迷\u201d嘛？！！！ 当然会 彩票也可以做到防沉迷 彩票防沉迷系统 不需要时刻盯看彩票 造成过度盲目消费 这个功能听起来是不是很智能","title":"不要老盯着我看！","url":"http://m.zhcw.com/khd/k3xhzs/gl/jq/lb/16747537.shtml"}]
     * jtH5url : http://m.zhcw.com/khd/k3xhzs/gl/jt/index.shtml
     * jtList : [{"logoFile":"http://m.zhcw.com/upload/resources/image/2017/12/18/716946.jpg","summary":"趋势分析服务：\u201c快3选号助手\u201d独家研发的K线图，能直观展示出号码的运行轨迹，是\u201c大数据\u201d最核心的功能模块，包括基本指标趋势分析和不同类型的综合指标趋势分析，让用户可以更准确地把握指标趋势。","title":"快3选号助手功能篇之趋势分析服务","url":"http://m.zhcw.com/khd/k3xhzs/gl/jt/lb/13516919.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2017/11/24/710354.jpg","summary":"快3选号助手使用篇的第三篇免费体验。介绍关于如何可以更快更便捷的免费体验快3选号助手的具体操作流程。","title":"快3选号助手使用篇之免费体验","url":"http://m.zhcw.com/khd/k3xhzs/gl/jt/lb/13635403.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2017/11/24/710358.jpg","summary":"快3选号助手使用篇的第四篇付费。介绍关于快3选号助手软件的付费具体操作流程及相关信息。","title":"快3选号助手使用篇之付费","url":"http://m.zhcw.com/khd/k3xhzs/gl/jt/lb/13635404.shtml"}]
     * newFlag : 1524726409756
     */


    private String cjwtH5url;
    private String jqH5url;
    private String jtH5url;
    private String newFlag;
    private List<CjwtListBean> cjwtList;
    private List<JqListBean> jqList;
    private List<JtListBean> jtList;

    public String getCjwtH5url() {
        return cjwtH5url;
    }

    public void setCjwtH5url(String cjwtH5url) {
        this.cjwtH5url = cjwtH5url;
    }

    public String getJqH5url() {
        return jqH5url;
    }

    public void setJqH5url(String jqH5url) {
        this.jqH5url = jqH5url;
    }

    public String getJtH5url() {
        return jtH5url;
    }

    public void setJtH5url(String jtH5url) {
        this.jtH5url = jtH5url;
    }

    public String getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(String newFlag) {
        this.newFlag = newFlag;
    }

    public List<CjwtListBean> getCjwtList() {
        return cjwtList;
    }

    public void setCjwtList(List<CjwtListBean> cjwtList) {
        this.cjwtList = cjwtList;
    }

    public List<JqListBean> getJqList() {
        return jqList;
    }

    public void setJqList(List<JqListBean> jqList) {
        this.jqList = jqList;
    }

    public List<JtListBean> getJtList() {
        return jtList;
    }

    public void setJtList(List<JtListBean> jtList) {
        this.jtList = jtList;
    }

    public static class CjwtListBean {
        @Override
        public String toString() {
            return "CjwtListBean{" +
                    "logoFile='" + logoFile + '\'' +
                    ", summary='" + summary + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        /**
         * logoFile :
         * summary : 邀请码是部分推广活动使用的，非必填项。
         * title : 邀请码是什么？
         * url : http://m.zhcw.com/khd/k3xhzs/gl/cjwt/lb/13417569.shtml
         */


        private String logoFile;
        private String summary;
        private String title;
        private String url;

        public String getLogoFile() {
            return logoFile;
        }

        public void setLogoFile(String logoFile) {
            this.logoFile = logoFile;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class JqListBean {
        @Override
        public String toString() {
            return "JqListBean{" +
                    "logoFile='" + logoFile + '\'' +
                    ", summary='" + summary + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        /**
         * logoFile : http://m.zhcw.com/upload/resources/image/2018/04/26/1083843.jpg
         * summary : 对于你选中的号码，你是否了解号码的历史趋势，是否对号码很有把握呢？ 小编为大家推荐个强大的功能→快3选号助手的“号码验证”功能!通过此功能我们可以查看号码趋势和遗漏情况，判断号码近期走势，对自己的号码更有把握哦~ 这个强大的功能怎么使用呢？ 第一步：点击“号码验证”进入到号码验证界面。
         * title : 号码验证分析，看这篇就够！
         * url : http://m.zhcw.com/khd/k3xhzs/gl/jq/lb/16861944.shtml
         */


        private String logoFile;
        private String summary;
        private String title;
        private String url;

        public String getLogoFile() {
            return logoFile;
        }

        public void setLogoFile(String logoFile) {
            this.logoFile = logoFile;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class JtListBean {
        @Override
        public String toString() {
            return "JtListBean{" +
                    "logoFile='" + logoFile + '\'' +
                    ", summary='" + summary + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        /**
         * logoFile : http://m.zhcw.com/upload/resources/image/2017/12/18/716946.jpg
         * summary : 趋势分析服务：“快3选号助手”独家研发的K线图，能直观展示出号码的运行轨迹，是“大数据”最核心的功能模块，包括基本指标趋势分析和不同类型的综合指标趋势分析，让用户可以更准确地把握指标趋势。
         * title : 快3选号助手功能篇之趋势分析服务
         * url : http://m.zhcw.com/khd/k3xhzs/gl/jt/lb/13516919.shtml
         */


        private String logoFile;
        private String summary;
        private String title;
        private String url;

        public String getLogoFile() {
            return logoFile;
        }

        public void setLogoFile(String logoFile) {
            this.logoFile = logoFile;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
