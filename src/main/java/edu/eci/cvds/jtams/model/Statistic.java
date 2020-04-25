package edu.eci.cvds.jtams.model;

    public class Statistic {
        private int count;
        private String title;

        public Statistic (){

        }
        public Statistic(int count, String area){
            this.count = count;
            this.title = area;
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
            return "Statistic{" + "count="
                    + count + ", area=" + title + '}';
        }
    }
