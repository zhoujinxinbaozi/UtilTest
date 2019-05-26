package sort;

public class QuickSort {

	private static void QuickSort(int[] array,int start,int end) {
		if(start<=end)
		{
			int key=array[start];//初始化保存基元
			int i=start,j;//初始化i,j
			for(j=start+1;j<=end;j++)

				if(array[j]<key)//如果此处元素小于基元，则把此元素和i+1处元素交换，并将i加1，如大于或等于基元则继续循环
				{
					int temp=array[j];
					array[j]=array[i+1];
					array[i+1]=temp;
					i++;
				}
			int temp=array[i];
			array[i]=array[start];
			array[start]=temp;
			//array[start]=array[i];//交换i处元素和基元
			//array[i]=key;
			QuickSort(array, start, i-1);//递归调用
			QuickSort(array, i+1, end);
		}
	}


	public static void main(String[] args)
	{
		int[] array=new int[]{27,99,0,8,13,64,86,16,7,10,88,25,90};
		QuickSort(array, 0, array.length-1);
		for(int i=0;i<array.length;i++)
		{
			System.out.println((i+1)+"th:"+array[i]);
		}
	}
}
