package BinarySearch;

import java.util.Arrays;

public class BinarySearch {
    private int[] arr;
    BinarySearch(int[] arr){
        this.arr=arr;
    }
    public  boolean binarySearch(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return true;
            }
            else if (target < nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
    public  int  noOfRotation(int[] nums) {
        /*
         * 1,2,3,4,5,6,7,8
         * 6,7,8,1,2,3,4,5
         *
         * */
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int next = (mid + 1) % right;
            int prev = (mid - 1 + right) % right;
            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
                return mid;
            } else if (nums[mid] <= nums[right]) {
                right = mid - 1;
            } else if (nums[mid] >= nums[left]) {
                left = mid + 1;
            }
        }
        return  -1;
    }
    public  int  firstOccurence(int[] nums,int target) {
        int left = 0, right = nums.length - 1;
        int firstOccurence=-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                firstOccurence=mid;
                right=mid-1;
            }
            else if (target < nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return firstOccurence;
    }
    public  int  lastOccurence(int[] nums,int target) {
        int left = 0, right = nums.length - 1;
        int firstOccurence=-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                firstOccurence=mid;
               left=mid+1;
            }
            else if (target < nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return firstOccurence;
    }
    public  int  findSmallestMissing(int[] nums) {
        int left = 0, right = nums.length - 1;
        int firstOccurence=-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == nums[mid]) {
                left=mid+1;
            }
            else if (mid<nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
    public  int[]  findfloorAndCeil(int[] nums,int target) {
        int left = 0, right = nums.length - 1;
        int firstOccurence=-1;
        int[] floorAndCeil=new int[2];
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid]==target){
                if(mid==0){
                    return new int[]{-1,nums[mid+1]};
                }
                else if(mid==nums.length-1){
                    return new int[]{nums[mid-1],-1};
                }
                 return   new int[]{nums[mid-1],nums[mid+1]};
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int nums[] = { 2, 5, 6, 8, 9, 10 };
        BinarySearch binarySearch= new BinarySearch(nums);
        System.out.println(binarySearch.binarySearch(nums,5));
        System.out.println(binarySearch.binarySearch(nums,2));
        System.out.println(binarySearch.binarySearch(nums,6));
        System.out.println(binarySearch.binarySearch(nums,8));
        System.out.println(binarySearch.binarySearch(nums,9));

        int circularrotatedArray[] = {8,9,10,2,5,6};
        System.out.println(binarySearch.noOfRotation(circularrotatedArray));


        int Ocurence[] ={1,2,3,3,3,4,4,5,6,6,6,7,8,9};
        System.out.println(binarySearch.firstOccurence(Ocurence,2)==1);
        System.out.println(binarySearch.firstOccurence(Ocurence,3)==2);
        System.out.println(binarySearch.firstOccurence(Ocurence,4)==5);
        System.out.println(binarySearch.firstOccurence(Ocurence,5)==7);
        System.out.println(binarySearch.firstOccurence(Ocurence,6)==8);



        System.out.println(binarySearch.lastOccurence(Ocurence,2)==1);
        System.out.println(binarySearch.lastOccurence(Ocurence,3)==4);
        System.out.println(binarySearch.lastOccurence(Ocurence,4)==6);
        System.out.println(binarySearch.lastOccurence(Ocurence,5)==7);
        System.out.println(binarySearch.lastOccurence(Ocurence,6)==10);



        System.out.println(Arrays.toString(binarySearch.findfloorAndCeil(new int[]{0,1,2,3,4,5,6,8,9,10},3)));
        System.out.println(Arrays.toString(binarySearch.findfloorAndCeil(new int[]{0,1,3,4,5,6,7,8,9,10},5)));
        System.out.println(Arrays.toString(binarySearch.findfloorAndCeil(new int[]{0,2,3,4,5,6,7,8,9,10},7)));
        System.out.println(Arrays.toString(binarySearch.findfloorAndCeil(new int[]{1,2,3,4,5,6,7,8,9,10},8)));
        System.out.println(Arrays.toString(binarySearch.findfloorAndCeil(new int[]{1,2,3,4,5,6,7,8,9,10},1)));
        System.out.println(Arrays.toString(binarySearch.findfloorAndCeil(new int[]{1,2,3,4,5,6,7,8,9,10},10)));





    }
}
