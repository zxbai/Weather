package com.zx.weather.mvp.model.entity;

import java.util.List;

/**
 * 项目名称：Weather
 * 类描述：
 * 创建人：ZX
 * 创建时间：2019/4/20 19:40
 * 修改人：ZX
 * 修改时间：2019/4/20 19:40
 * 修改备注：
 */
public class Weather1 {
    /**
     * cityid : 401020101
     * city : 迈阿密
     * cityEn : Miami
     * country : 美国
     * countryEn : United States
     * update_time : 2019-04-22 07:30:00
     * data : [{"wea":"多云","wea_img":"yun","tem1":"23","tem2":"17","win":["东北风"],"win_speed":"<3级","hours":[{"hours":"21日19时","wea":"晴","wea_img":"qing","tem":"23","win":"东风","win_speed":"<3级"},{"hours":"21日22时","wea":"多云","wea_img":"yun","tem":"20","win":"东北风","win_speed":"<3级"},{"hours":"22日01时","wea":"多云","wea_img":"yun","tem":"19","win":"东北风","win_speed":"<3级"},{"hours":"22日04时","wea":"多云","wea_img":"yun","tem":"18","win":"东北风","win_speed":"<3级"}]},{"wea":"多云","wea_img":"yun","tem1":"28","tem2":"18","win":["东北风","东北风"],"win_speed":"3-4级","hours":[{"hours":"22日07时","wea":"晴","wea_img":"qing","tem":"18","win":"东北风","win_speed":"<3级"},{"hours":"22日10时","wea":"多云","wea_img":"yun","tem":"25","win":"东北风","win_speed":"<3级"},{"hours":"22日13时","wea":"晴","wea_img":"qing","tem":"27","win":"东北风","win_speed":"3-4级"},{"hours":"22日16时","wea":"晴","wea_img":"qing","tem":"26","win":"东北风","win_speed":"3-4级"},{"hours":"22日19时","wea":"晴","wea_img":"qing","tem":"24","win":"东北风","win_speed":"3-4级"},{"hours":"22日22时","wea":"晴","wea_img":"qing","tem":"22","win":"东北风","win_speed":"3-4级"},{"hours":"23日01时","wea":"晴","wea_img":"qing","tem":"21","win":"东北风","win_speed":"3-4级"},{"hours":"23日04时","wea":"晴","wea_img":"qing","tem":"20","win":"东北风","win_speed":"3-4级"}]},{"wea":"多云转晴","wea_img":"yun","tem1":"28","tem2":"20","win":["东北风","东北风"],"win_speed":"3-4级","hours":[{"hours":"23日07时","wea":"多云","wea_img":"yun","tem":"21","win":"东北风","win_speed":"3-4级"},{"hours":"23日10时","wea":"多云","wea_img":"yun","tem":"26","win":"东北风","win_speed":"3-4级"},{"hours":"23日13时","wea":"多云","wea_img":"yun","tem":"28","win":"东北风","win_speed":"3-4级"},{"hours":"23日16时","wea":"晴","wea_img":"qing","tem":"27","win":"东北风","win_speed":"3-4级"},{"hours":"23日19时","wea":"晴","wea_img":"qing","tem":"25","win":"东北风","win_speed":"3-4级"},{"hours":"23日22时","wea":"晴","wea_img":"qing","tem":"25","win":"东北风","win_speed":"3-4级"},{"hours":"24日01时","wea":"晴","wea_img":"qing","tem":"23","win":"东北风","win_speed":"3-4级"},{"hours":"24日04时","wea":"晴","wea_img":"qing","tem":"21","win":"东北风","win_speed":"<3级"}]},{"wea":"晴","wea_img":"qing","tem1":"30","tem2":"20","win":["东风","东风"],"win_speed":"<3级","hours":[{"hours":"24日07时","wea":"晴","wea_img":"qing","tem":"22","win":"东北风","win_speed":"<3级"},{"hours":"24日10时","wea":"晴","wea_img":"qing","tem":"28","win":"东风","win_speed":"<3级"},{"hours":"24日13时","wea":"晴","wea_img":"qing","tem":"29","win":"东风","win_speed":"<3级"},{"hours":"24日16时","wea":"晴","wea_img":"qing","tem":"30","win":"东风","win_speed":"<3级"},{"hours":"24日19时","wea":"晴","wea_img":"qing","tem":"28","win":"东风","win_speed":"<3级"},{"hours":"25日01时","wea":"晴","wea_img":"qing","tem":"22","win":"东风","win_speed":"<3级"}]},{"wea":"多云转小雨","wea_img":"yun","tem1":"30","tem2":"21","win":["东南风","东南风"],"win_speed":"<3级转3-4级","hours":[{"hours":"25日07时","wea":"晴","wea_img":"qing","tem":"22","win":"东风","win_speed":"<3级"},{"hours":"25日13时","wea":"多云","wea_img":"yun","tem":"30","win":"东南风","win_speed":"<3级"},{"hours":"25日19时","wea":"多云","wea_img":"yun","tem":"27","win":"南风","win_speed":"<3级"},{"hours":"26日01时","wea":"小雨","wea_img":"yu","tem":"22","win":"东南风","win_speed":"3-4级"}]},{"wea":"小雨","wea_img":"yu","tem1":"28","tem2":"22","win":["西南风","北风"],"win_speed":"5-6级转3-4级","hours":[{"hours":"26日07时","wea":"小雨","wea_img":"yu","tem":"22","win":"东南风","win_speed":"3-4级"},{"hours":"26日13时","wea":"中雨","wea_img":"yu","tem":"27","win":"西南风","win_speed":"5-6级"},{"hours":"26日19时","wea":"小雨","wea_img":"yu","tem":"25","win":"西南风","win_speed":"3-4级"},{"hours":"27日01时","wea":"小雨","wea_img":"yu","tem":"25","win":"北风","win_speed":"3-4级"}]},{"wea":"多云转小雨","wea_img":"yun","tem1":"27","tem2":"20","win":["东北风","东南风"],"win_speed":"3-4级转<3级","hours":[{"hours":"27日07时","wea":"小雨","wea_img":"yu","tem":"24","win":"北风","win_speed":"3-4级"},{"hours":"27日13时","wea":"多云","wea_img":"yun","tem":"26","win":"东北风","win_speed":"3-4级"},{"hours":"27日19时","wea":"多云","wea_img":"yun","tem":"26","win":"东北风","win_speed":"<3级"},{"hours":"28日01时","wea":"小雨","wea_img":"yu","tem":"22","win":"南风","win_speed":"<3级"}]}]
     */

    private String cityid;
    private String city;
    private String cityEn;
    private String country;
    private String countryEn;
    private String update_time;
    private List<DataBean> data;

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityEn() {
        return cityEn;
    }

    public void setCityEn(String cityEn) {
        this.cityEn = cityEn;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * wea : 多云
         * wea_img : yun
         * tem1 : 23
         * tem2 : 17
         * win : ["东北风"]
         * win_speed : <3级
         * hours : [{"hours":"21日19时","wea":"晴","wea_img":"qing","tem":"23","win":"东风","win_speed":"<3级"},{"hours":"21日22时","wea":"多云","wea_img":"yun","tem":"20","win":"东北风","win_speed":"<3级"},{"hours":"22日01时","wea":"多云","wea_img":"yun","tem":"19","win":"东北风","win_speed":"<3级"},{"hours":"22日04时","wea":"多云","wea_img":"yun","tem":"18","win":"东北风","win_speed":"<3级"}]
         */

        private String wea;
        private String wea_img;
        private String tem1;
        private String tem2;
        private String win_speed;
        private List<String> win;
        private List<HoursBean> hours;

        public String getWea() {
            return wea;
        }

        public void setWea(String wea) {
            this.wea = wea;
        }

        public String getWea_img() {
            return wea_img;
        }

        public void setWea_img(String wea_img) {
            this.wea_img = wea_img;
        }

        public String getTem1() {
            return tem1;
        }

        public void setTem1(String tem1) {
            this.tem1 = tem1;
        }

        public String getTem2() {
            return tem2;
        }

        public void setTem2(String tem2) {
            this.tem2 = tem2;
        }

        public String getWin_speed() {
            return win_speed;
        }

        public void setWin_speed(String win_speed) {
            this.win_speed = win_speed;
        }

        public List<String> getWin() {
            return win;
        }

        public void setWin(List<String> win) {
            this.win = win;
        }

        public List<HoursBean> getHours() {
            return hours;
        }

        public void setHours(List<HoursBean> hours) {
            this.hours = hours;
        }

        public static class HoursBean {
            /**
             * hours : 21日19时
             * wea : 晴
             * wea_img : qing
             * tem : 23
             * win : 东风
             * win_speed : <3级
             */

            private String hours;
            private String wea;
            private String wea_img;
            private String tem;
            private String win;
            private String win_speed;

            public String getHours() {
                return hours;
            }

            public void setHours(String hours) {
                this.hours = hours;
            }

            public String getWea() {
                return wea;
            }

            public void setWea(String wea) {
                this.wea = wea;
            }

            public String getWea_img() {
                return wea_img;
            }

            public void setWea_img(String wea_img) {
                this.wea_img = wea_img;
            }

            public String getTem() {
                return tem;
            }

            public void setTem(String tem) {
                this.tem = tem;
            }

            public String getWin() {
                return win;
            }

            public void setWin(String win) {
                this.win = win;
            }

            public String getWin_speed() {
                return win_speed;
            }

            public void setWin_speed(String win_speed) {
                this.win_speed = win_speed;
            }
        }
    }
}
