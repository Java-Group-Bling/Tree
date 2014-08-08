package sufa;

import org.junit.Test;

public class PaiXu {
	/**
	 * 冒泡排序
	 */
	@Test
	public void maoPao(){
		int [] num = {2,4,1,5,2,3,7,9,6,7,8,4};
		int tmp;
		int i,j,k = 0;
		for(i = num.length-1;i>0;i=k){
			for(k=j=0;j<i;j++){
				if(num[j]>num[j+1]){
					tmp = num[j];
					num[j] = num[j+1];
					num[j+1] = tmp;
					k = j;
				}
			}

		}
		
		System.out.println("冒泡排序后：");
		for(int p=0;p<num.length;p++){
			System.out.print(num[p]+",");
		}
	}
	/**
	 * 选择排序
	 */
	@Test
	public void selectSort(){
		int [] num = {2,4,1,5,2,3,7,9,6,7,8,4};
		int i,j,k;
		int tmp;
		for(i=0;i<num.length-1;i++){
			for(k=i,j=i+1;j<num.length;j++){
				if(num[k]>num[j]){
					k = j;
				}
			}
			if(k!=j){
				tmp = num[k];
				num[k] = num[i];
				num[i] = tmp;
			}
		}
		System.out.println("快速排序后：");
		for(int p=0;p<num.length;p++){
			System.out.print(num[p]+",");
		}
		
	}
	/**
	 * 插入排序
	 */
	@Test
	public void insertionSort(){
		int [] num = {2,4,1,5,2,3,7,9,6,7,8,4};
		int i,j;
		int tmp;
		for(i=1;i<num.length;i++){
			tmp = num[i];
			for(j=i-1;j>=0&&num[j]>tmp;j--){
				num[j+1] = num[j];
			}
			num[j+1]=tmp;
		}
		System.out.println("插入排序后：");
		for(int p=0;p<num.length;p++){
			System.out.print(num[p]+",");
		}
		
	}
	/**
	 * 希尔排序
	 */
	@Test
	public void sehllSort(){
		int [] num = {2,4,1,5,2,3,7,9,6,7,8,4};
		int i,j,k;
		int tmp;
		k = num.length/2;
		while(k>0){
			for(i=k;i<num.length;i++){
				tmp = num[i];
				for(j=i-k;j>=0&&num[j]>tmp;j-=k){
					num[j+k] = num[j];
				}
				num[j+k] = tmp;
			}
			k/=2;
		}
		System.out.println("希尔排序后：");
		for(int p=0;p<num.length;p++){
			System.out.print(num[p]+",");
		}
		
	}
	/**
	 * 快速排序
	 * 快速排序被认为是最快的内排序算法。
	 * 当然，当数据量少时，快速排序甚至不及简单的排序算法；
	 * 此外，当数据本身已有序时，快速排序的效率极低。 一般情况下，快速排序的时间复杂度为O(nlogn)。 
	 * 快速排序因其递归需要额外空间，数据量大时有可能会造成堆栈溢出，使程序会崩掉（还好现在操作系统做得好，不容易死机）。
	 * 想办法转为非递归可避免这问题。
	 */
	@Test
	public void quickSort(){
		int [] num = {2,4,1,5,2,3,7,9,6,7,8,4};
		quickSortContent(num,0,num.length-1);
		
		System.out.println("快速排序后：");
		for(int p=0;p<num.length;p++){
			System.out.print(num[p]+",");
		}
		
	}
	public void quickSortContent(int [] num,int l,int r){
		
		if(l>=r) return;
		
		int i = l;//从左到右的游标
		int j = r+1;//从右到左的游标
		int tmp;
		int pivot = num[l];//以num[l]为支点
		while(true){
			while(num[++i]<pivot && i<r);//从左边找>=pivot的元素
			while(num[--j]>pivot && j>l);//从右边找<=pivot的元素
			
			if(i>=j) break;//如未找到交换对,退出循环
			
			tmp = num[i];
			num[i] = num[j];
			num[j] = tmp;
		}
		//将支点a[l]与a[j]交换
		num[l] = num[j];
		num[j] = pivot;
		quickSortContent(num,l,j-1);
		quickSortContent(num,j+1,r);
		
	}
	
}
