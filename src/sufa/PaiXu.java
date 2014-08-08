package sufa;

import org.junit.Test;

public class PaiXu {
	/**
	 * ð������
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
		
		System.out.println("ð�������");
		for(int p=0;p<num.length;p++){
			System.out.print(num[p]+",");
		}
	}
	/**
	 * ѡ������
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
		System.out.println("���������");
		for(int p=0;p<num.length;p++){
			System.out.print(num[p]+",");
		}
		
	}
	/**
	 * ��������
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
		System.out.println("���������");
		for(int p=0;p<num.length;p++){
			System.out.print(num[p]+",");
		}
		
	}
	/**
	 * ϣ������
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
		System.out.println("ϣ�������");
		for(int p=0;p<num.length;p++){
			System.out.print(num[p]+",");
		}
		
	}
	/**
	 * ��������
	 * ����������Ϊ�������������㷨��
	 * ��Ȼ������������ʱ�������������������򵥵������㷨��
	 * ���⣬�����ݱ���������ʱ�����������Ч�ʼ��͡� һ������£����������ʱ�临�Ӷ�ΪO(nlogn)�� 
	 * ������������ݹ���Ҫ����ռ䣬��������ʱ�п��ܻ���ɶ�ջ�����ʹ�����������������ڲ���ϵͳ���úã���������������
	 * ��취תΪ�ǵݹ�ɱ��������⡣
	 */
	@Test
	public void quickSort(){
		int [] num = {2,4,1,5,2,3,7,9,6,7,8,4};
		quickSortContent(num,0,num.length-1);
		
		System.out.println("���������");
		for(int p=0;p<num.length;p++){
			System.out.print(num[p]+",");
		}
		
	}
	public void quickSortContent(int [] num,int l,int r){
		
		if(l>=r) return;
		
		int i = l;//�����ҵ��α�
		int j = r+1;//���ҵ�����α�
		int tmp;
		int pivot = num[l];//��num[l]Ϊ֧��
		while(true){
			while(num[++i]<pivot && i<r);//�������>=pivot��Ԫ��
			while(num[--j]>pivot && j>l);//���ұ���<=pivot��Ԫ��
			
			if(i>=j) break;//��δ�ҵ�������,�˳�ѭ��
			
			tmp = num[i];
			num[i] = num[j];
			num[j] = tmp;
		}
		//��֧��a[l]��a[j]����
		num[l] = num[j];
		num[j] = pivot;
		quickSortContent(num,l,j-1);
		quickSortContent(num,j+1,r);
		
	}
	
}
