package zuoshengsuanfa.jichuban.QueueAndStack;

/**
 *      毛毛雨     2018/10/18
 * */
public class Code_01_用数组实现大小固定的队列和栈 {
    public static  class ArrayStack{
        private Integer[] arr;
        private Integer size;
        public ArrayStack(int initsize){
            if (initsize < 0){
                throw new IllegalArgumentException("长度至少是0");
            }
            arr = new Integer[initsize];
            size = 0;
        }

        public Integer peek(){
            if (size == 0){
                return  null;
            }
            return arr[size--];
        }
        public void push(int obj){
            if (size == arr.length){
                throw new ArrayIndexOutOfBoundsException("这个栈满了");
            }
            arr[size++] = obj;
        }

        public Integer pop(){
            if (size == 0){
                throw new ArrayIndexOutOfBoundsException("栈为空");
            }
            return arr[--size];
        }
    }

    public static class ArrayQueue{
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        public ArrayQueue(int initsize) {
           if (initsize < 0){
               throw new IllegalArgumentException("长度至少是0");
           }
           arr = new Integer[initsize];
           size = 0;
           first = 0;
           last = 0;
        }

        public Integer peek(){
            if (size == 0){
                return null;
            }
            return arr[first];
        }
        public void push(int obj){
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("队列以满");
            }
            size++;
            arr[last] = obj;
            last = last == arr.length -1 ?0 : last+1;
        }

        public Integer poll(){
            if (size < 0){
                throw new ArrayIndexOutOfBoundsException("队列为空");
            }
            size --;
            int tmp = first;
            first = first == arr.length -1 ? 0:first+1;
            return arr[tmp];
        }
    }
}
