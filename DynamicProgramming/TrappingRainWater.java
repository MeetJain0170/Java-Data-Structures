public class TrappingRainWater {
    public int trap(int[]height){
        int left=0;
        int right=height.length;
        int lmax=height[left];
        int rmax=height[right];
        int water=0;
        while(left<right){
            if(lmax<rmax){
                left++;
                lmax=Math.max(lmax,height[left]);
                water+=lmax-height[left];
            }else{
                right--;
                rmax=(Math.max(rmax,height[right]));
                water+=rmax-height[right];
            }
        }return water;
    }
}
