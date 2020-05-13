package edu.eci.cvds.jtams.model;

    public class Statistic {
        private int count;
        private int scount;
        private String title;
        private String typeStatusId;

        public Statistic(int count, String area, String typeStatusId, int scount){
            this.count = count;
            this.title = area;
            this.typeStatusId = typeStatusId;
            this.scount = scount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTypeStatusId() {
            return typeStatusId;
        }

        public void setTypeStatusId(String typeStatusId) {
            this.typeStatusId = typeStatusId;
        }

        public int getScount() {
            return scount;
        }

        public void setScount(int scount) {
            this.scount = scount;
        }

        public Statistic (){

        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getTittle() {
            return title;
        }

        public void setTittle(String area) {
            this.title = title;
        }


        @Override
        public String toString() {
            return "Statistic {" + "count="
                    + count + ", area=" + title +
                    "Scount=" + scount + ", Status=" + typeStatusId +'}';
        }
    }
