import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class Mergesort{
    private int[] numbers;
    private int[] helper;

    public void sort(int[] values){
        this.numbers = values;
        int number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
    }

    private void mergesort(int low, int high){
        if(low<high){
            int middle = low + (high-low)/2;
            mergesort(low,middle);
            mergesort(middle+1,high);
            merge(low, middle,high);
        }
    }

     private void merge(int low, int middle, int high){
         System.arraycopy(numbers, low, helper, low, high + 1 - low);

        int i=low;
        int j=middle+1;
        int k=low;

        while(i<=middle && j<=high){
            if(helper[i]<=helper[j]){
                numbers[k]= helper[i];
                i++;
            }else{
                numbers[k] = helper[j];
                j++;
            }
            k++;

        }

        while(i<=middle){
            numbers[k]=helper[i];
            k++;
            i++;
        }
    }


}

public class sortMethod {

    private static int Arr[];
    private static Random rd = new Random();

    public static void main(String[] args) throws IOException{

        long t1,t2;
        int met;
        int count;
        int rep;

        System.out.println("Arturs Kuzmiks 12.gr. 111REB779");

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("method(1/11): ");
            met = Integer.parseInt(br.readLine());

            if(!String.valueOf(met).matches("[0-9]+")) throw new IllegalArgumentException();

            System.out.print("Atkartor: ");
            rep =Integer.parseInt(br.readLine());

            System.out.print("count: ");
            count = Integer.parseInt(br.readLine());

            Arr=new int [count];
            //System.out.println("items:");

            for(int i=0;i<count;i++)
                //Arr[i]=Integer.parseInt(br.readLine());
                Arr[i]=rd.nextInt(100);

        }catch (IllegalArgumentException e){
            System.out.println("input-output error");
            return;
        }

        boolean out = true;
        final int [] temparr = new int [count];
        System.arraycopy(Arr, 0, temparr, 0, Arr.length);

        loop:for(;;) {
            switch (met) {
                case 1:
                    System.out.println();
                    for(int i=0;i<rep;i++){
                        System.arraycopy(temparr, 0, Arr, 0, Arr.length);
                        t1 = System.nanoTime();
                        sumsordMethod(Arr);
                        t2 = System.nanoTime();
                        System.out.print("\nMethod: "+ met+ " Iter: "+i+" time "+ (t2-t1)+"\t");
                    }

                    if(out)
                        break loop;
                    break;

                case 2:
                    System.out.println();
                    for(int i=0;i<rep;i++){
                        System.arraycopy(temparr, 0, Arr, 0, Arr.length);
                        t1 = System.nanoTime();
                        iterqsMethod(Arr);
                        t2 = System.nanoTime();
                        System.out.print("\nMethod: "+ met+ " Iter: "+i+" time "+ (t2-t1)+"\t");
                    }

                    if(out)
                        break loop;
                    break;

                case 3:
                    System.out.println();
                    for(int i=0;i<rep;i++){
                        System.arraycopy(temparr, 0, Arr, 0, Arr.length);
                        t1 = System.nanoTime();
                        uzliekMethod(Arr);
                        t2 = System.nanoTime();
                        System.out.print("\nMethod: "+ met+ " Iter: "+i+" time "+ (t2-t1)+"\t");
                    }

                    if(out)
                        break loop;
                    break;

                case 4:
                    System.out.println();
                    for(int i=0;i<rep;i++){
                        System.arraycopy(temparr, 0, Arr, 0, Arr.length);
                        t1 = System.nanoTime();
                        uzlapMethodSK(Arr);
                        t2 = System.nanoTime();
                        System.out.print("\nMethod: "+ met+ " Iter: "+i+" time "+ (t2-t1)+"\t");
                    }

                    if(out)
                        break loop;
                    break;

                case 5:
                    System.out.println();
                    for(int i=0;i<rep;i++){
                        System.arraycopy(temparr, 0, Arr, 0, Arr.length);
                        t1 = System.nanoTime();
                        uzlapMethodPnP(Arr);
                        t2 = System.nanoTime();
                        System.out.print("\nMethod: "+ met+ " Iter: "+i+" time "+ (t2-t1)+"\t");
                    }


                    if(out)
                        break loop;
                    break;

                case 6:
                    System.out.println();
                    for(int i=0;i<rep;i++){
                        System.arraycopy(temparr, 0, Arr, 0, Arr.length);
                        t1 = System.nanoTime();
                        kvadMethod(Arr);
                        t2 = System.nanoTime();
                        System.out.print("\nMethod: "+ met+ " Iter: "+i+" time "+ (t2-t1)+"\t");
                    }

                    if(out)
                        break loop;
                    break;

                case 7:
                    System.out.println();
                    for(int i=0;i<rep;i++){
                        System.arraycopy(temparr, 0, Arr, 0, Arr.length);
                        t1 = System.nanoTime();
                        sellaMethod(Arr);
                        t2 = System.nanoTime();
                        System.out.print("\nMethod: "+ met+ " Iter: "+i+" time "+ (t2-t1)+"\t");
                    }
                    if(out)
                        break loop;
                    break;

                case 8:
                    System.out.println();
                    for(int i=0;i<rep;i++){
                        System.arraycopy(temparr, 0, Arr, 0, Arr.length);
                        t1 = System.nanoTime();
                        secapskMethod(Arr);
                        t2 = System.nanoTime();
                        System.out.print("\nMethod: "+ met+ " Iter: "+i+" time "+ (t2-t1)+"\t");
                    }

                    if(out)
                        break loop;
                    break;

                case 9:
                    System.out.println();
                    for(int i=0;i<rep;i++){
                        System.arraycopy(temparr, 0, Arr, 0, Arr.length);
                        t1 = System.nanoTime();
                        qsrecMethod(Arr, 0, Arr.length - 1);
                        t2 = System.nanoTime();
                        System.out.print("\nMethod: "+ met+ " Iter: "+i+" time "+ (t2-t1)+"\t");
                    }

                    if(out)
                        break loop;
                    break;

                case 10:
                    System.out.println();
                    for(int i=0;i<rep;i++){
                        System.arraycopy(temparr, 0, Arr, 0, Arr.length);
                        Mergesort sorter = new Mergesort();

                        t1 = System.nanoTime();
                        sorter.sort(Arr);
                        t2 = System.nanoTime();
                        System.out.print("\nMethod: "+ met+ " Iter: "+i+" time "+ (t2-t1)+"\t");
                    }

                    if(out)
                        break loop;
                    break;

                case 11:
                    System.out.println();
                    for(int i=0;i<rep;i++){
                        System.arraycopy(temparr, 0, Arr, 0, Arr.length);
                        t1 = System.nanoTime();
                        timsortMethod(Arr);
                        t2 = System.nanoTime();
                        System.out.print("\nMethod: "+ met+ " Iter: "+i+" time "+ (t2-t1)+"\t");
                    }
                    break;

                case 0:
                    out=false;
                    break;
                default:
                    System.out.println("input-output error");
                    return;
            }
            if(met==11) break;
            met++;
        }

}
    private static void sumsordMethod(int[] a){

        int less[]=new int[a.length];
        int equal[]=new int[a.length];
        int rez[]=new int[a.length];

        for(int i=0;i<a.length;i++) {
            for (int j : a) {
                if (a[i] > j) less[i]++;
                if (a[i] == j) equal[i]++;
            }
        }

        for(int i=0;i<a.length;i++){
            int k=less[i];
            for(int j=0;j<equal[i];j++)
                rez[k+j]=a[i];
        }
        Arr=rez;

    }

    private static void iterqsMethod(int[] a){

        int left[]=new int[a.length/2];
        int right[]=new int[a.length/2];
        int stackpos=1;
        int m;

        left[0]=0;
        right[0]=a.length-1;

        while(stackpos>0){
            stackpos--;
            int l = left[stackpos];
            int r = right[stackpos];
            while(l<r) {
                m = a[rd.nextInt(r-l)+(1+l)];
                int i = l;
                int j = r;

                while(i<=j) {
                    while (a[i] < m) i++;
                    while (a[j] > m) j--;

                    if (i <= j) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        i++;
                        j--;
                    }
                }

                if (i < r) {
                    left[stackpos] = i;
                    right[stackpos] = r;
                    stackpos++;
                }
                r=j;
            }

        }

    }

    private static void uzliekMethod(int[] a){
        int l;
        int r;
        int j;
        int [] b = new int[2*a.length-1];

        l=r=a.length-1;
        b[r]=a[0];

        for(int i=1;i<a.length;i++){
            if(b[l]>=a[i]){
                l--;
                b[l]=a[i];
            }else{
                if(b[r]<=a[i]){
                    r++;
                    b[r]=a[i];
                }else{
                    j=l;
                    while(b[j]<a[i] && l<=r){
                        j++;
                    }
                    if(j-l<=r-j){
                        int m=l;
                        while (m<=j-1) {
                            b[m-1]=b[m];
                            m++;
                        }
                        l--;
                        b[j-1]=a[i];
                    }else{
                        int m=r;
                        while (m>=j) {
                            b[m+1]=b[m];
                            m--;
                        }
                        r++;
                        b[j]=a[i];
                    }
                }
            }
        }
        int i=0;
        while (i<=r-l) {
            a[i]=b[i+l];
            i++;
        }

    }

    private static void uzlapMethodSK(int[] a){
        int l;
        int r;

        l=0;
        r=a.length-1;

        while(l<r){
            for(int i=l;i<r;i++){
                if(a[i]>a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
            r--;
            for(int i=r;i>l;i--){
                if(a[i-1]>a[i]){
                    int temp =a[i];
                    a[i] = a[i-1];
                    a[i-1]=temp;
                }
            }
            l++;
        }

    }

    private static void uzlapMethodPnP(int[] a){
        boolean b=true;

        while(b){
            b=false;
            for(int i=0;i<a.length-1;i+=2){
                if(a[i]>a[i+1]){
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    b=true;
                }
            }
            for(int i=1;i<a.length-1;i+=2){
                if(a[i]>a[i+1]){
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    b=true;
                }
            }
        }
    }

    private static void kvadMethod(int[] a){
        int gCnt=(int) Math.rint(Math.sqrt(a.length));
        int gLen=(int) Math.sqrt(a.length);
        int min;
        int bmin=0;

        int[] buf = new int [gCnt];
        int[][] gBorder = new int [gCnt][2];

        gBorder[0][0]=0;
        gBorder[0][1]=gLen-1;

        for(int i=1;i<gCnt;i++){
            gBorder[i][0]=gBorder[i-1][0]+gLen;
            gBorder[i][1]=gBorder[i-1][1]+gLen;
        }

        gBorder[gCnt-1][1]=a.length-1;

        for(int i=0;i<gCnt;i++){
            min = gBorder[i][0];
            for(int j=gBorder[i][0]+1;j<=gBorder[i][1];j++)
                if(a[min]>a[j]) min=j;
            buf[i]=a[min];
            a[min]=Integer.MAX_VALUE;
        }
        int[] b=new int[a.length];

        for(int k=0;k<b.length;k++){
            for(int i=0;i<gCnt;i++) {
                int temp=buf[i];
                for (int j = 0; j < gCnt - 1; j++) {
                    if (temp < buf[j + 1] && temp<buf[bmin])
                        bmin = i;
                }
            }
            b[k]=buf[bmin];
            buf[bmin]=Integer.MAX_VALUE;
            min=gBorder[bmin][0];

            for(int i=gBorder[bmin][0]+1;i<=gBorder[bmin][1];i++)
                if(a[min]>a[i]) min=i;
            buf[bmin]=a[min];
            a[min]=Integer.MAX_VALUE;
        }
        Arr=b;
    }

    private static void sellaMethod(int[] a){
        int t;

        t=(int) (Math.log(a.length)/Math.log(2)-1);

        int[] h = new int[t];
        h[0]=1;
        for(int i=1;i<h.length;i++)
            h[i]=2*h[i-1]+1;
        t--;

        while(t>=0){
            int inc=h[t];
            t--;
            for(int i=inc;i<a.length;i++){
                int temp=a[i];
                int j=i-inc;
                while (j>=0 && a[j]>temp) {
                    a[j+inc]=a[j];
                    j=j-inc;
                }
                a[j+inc]=temp;
            }
        }
    }

    private static void secapskMethod(int[] a){
        int[] b;
        int[] c = new int[a.length];
        int[] tmp;
        int len;
        int ri,rj;

        len=1;
        b=a;

        while(len<b.length){
            int n;
            for(int k=0;k<b.length;k=k+2*len){
                n=k;
                int i=k;
                int j=k+len;

                if(k+len<b.length) ri=k+len;
                else ri=b.length;

                if(k+2*len<b.length) rj=k+2*len;
                else rj=b.length;

                while(i<ri && j<rj){
                    if(b[i]<b[j]){
                        c[n]=b[i];
                        i++;
                        n++;
                    }else{
                        c[n]=b[j];
                        j++;
                        n++;
                    }
                }

                while(i<ri){
                    c[n]=b[i];
                    i++;
                    n++;
                }

                while(j<rj){
                    c[n]=b[j];
                    j++;
                    n++;
                }
            }
            len=2*len;
            tmp=b;
            b=c;
            c=tmp;
        }
    Arr=b;
    }

    private static void qsrecMethod(int[] a,int l,int r){
        int m;
        int i,j;

        m = a[rd.nextInt(r-l)+(1+l)];
        i=l;
        j=r;
        while(i<=j) {
            while (a[i] < m) i++;
            while (a[j] > m) j--;

            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if(j>l) qsrecMethod(a,l,j);
        if(r>i) qsrecMethod(a,i,r);
    }

    private static void timsortMethod(int[] a){
        int RUN = 32;

        for(int i=0;i<a.length+1;i+=RUN){

            for(int ii=i+1;ii<=Math.min((i+31),(a.length-1));ii++){
                int temp=a[ii];
                int j=ii-1;
                while(j>=i && a[j]>temp){
                    a[j+1]=a[j];
                    j--;
                }
                a[j+1]=temp;
            }
        }

        for(int size=RUN;size<a.length;size=2*size){

            for(int left=0;left<a.length;left+=2*size){

                int mid=left+size-1;
                int right=Math.min((left+ 2*size-1),(a.length-1));

                int len1 = mid - left + 1;
                int len2 = right - mid;
                if(len2<0)
                    len1=len1+len2;
                int[] leftt=new int[len1];
                int[] rightt=new int[Math.abs(len2)];

                for(int i=0;i<len1;i++)
                    leftt[i]=a[left+i];

                for (int i = 0; i < len2; i++)
                    rightt[i] = a[mid + 1 + i];

                int i = 0;
                int j = 0;
                int k = left;

                while (i < len1 && j < len2) {
                    if (leftt[i] <= rightt[j]) {
                        a[k] = leftt[i];
                        i++;
                    } else {
                        a[k] = rightt[j];
                        j++;
                    }
                    k++;
                }

                while (i < len1) {
                    a[k] = leftt[i];
                    k++;
                    i++;
                }

                while (j < len2) {
                    a[k] = rightt[j];
                    k++;
                    j++;
                }

            }
        }
    }

}
