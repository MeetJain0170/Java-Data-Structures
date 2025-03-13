public class MostWaterContainer {
    public static int maxArea(int[] height){
        int maxVol=0;
        int start=0;
        int end=height.length-1;
        while(start<end){
            int vol=Math.min(height[start],height[end])*(end-start);
            if(vol>maxVol){
                maxVol = vol;
            }
            if(height[start]>height[end]){
                end--;
            }else{
                start++;
            }
        }return maxVol;
    }
    public static void main(String[] args) {
        int[]height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
