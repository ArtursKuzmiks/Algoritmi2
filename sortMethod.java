import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class sortMethod {

    private static int Arr[];
    private static Random rd = new Random();

    public static void main(String[] args) throws IOException{

        long t1,t2;
        int met;
        int count;

        System.out.println("Arturs Kuzmiks 12.gr. 111REB779");

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("method: ");
            met = Integer.parseInt(br.readLine());

            if(!String.valueOf(met).matches("[0-9]+") || String.valueOf(met).length()>1) throw new IllegalArgumentException();

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
        t1=t2=0;

        loop:for(;;) {
            System.arraycopy(temparr, 0, Arr, 0, Arr.length);
            switch (met) {
                case 1:

                    t1 = System.nanoTime();
                    sumsordMethod(Arr);
                    t2 = System.nanoTime();

                    if(out)
                        break loop;
                    break;
                case 2:

                    t1 = System.nanoTime();
                    iterqsMethod(Arr);
                    t2 = System.nanoTime();

                    if(out)
                        break loop;
                    break;
                case 3:

                    t1 = System.nanoTime();
                    uzliekMethod(Arr);
                    t2 = System.nanoTime();

                    if(out)
                        break loop;
                    break;
                case 4:

                    t1 = System.nanoTime();
                    uzlapMethodSK(Arr);
                    t2 = System.nanoTime();

                    if(out)
                        break loop;
                    break;
                case 5:

                    t1 = System.nanoTime();
                    uzlapMethodPnP(Arr);
                    t2 = System.nanoTime();


                    if(out)
                        break loop;
                    break;
                case 6:

                    t1 = System.nanoTime();
                    kvadMethod(Arr);
                    t2 = System.nanoTime();

                    if(out)
                        break loop;
                    break;
                case 7:

                    t1 = System.nanoTime();
                    sellaMethod(Arr);
                    t2 = System.nanoTime();

                    if(out)
                        break loop;
                    break;
                case 8:

                    t1 = System.nanoTime();
                    secapskMethod(Arr);
                    t2 = System.nanoTime();

                    if(out)
                        break loop;
                    break;
                case 9:

                    t1 = System.nanoTime();
                    qsMethod(Arr, 0, Arr.length - 1);
                    t2 = System.nanoTime();

                    break;

                case 0:
                    out=false;
                    break;
                default:
                    System.out.println("input-output error");
                    return;
            }
            if (met >= 1) {
                System.out.println("\nMethod " + met + " sorted time: " + (t2 - t1));
                //for (int i : Arr) System.out.print(i + "\t");
            }
            if(met==9) break;
            met++;
        }

}
    private static void sumsordMethod(int[] a){

        int less[]=new int[a.length];
        int equal[]=new int[a.length];
        int rez[]=new int[a.length];

        for(int i=0;i<a.length;i++){

            for (int j : a) {
                if (a[i] > j) less[i]++;
                if (a[i] == j) equal[i]++;
            }

            for(int j=less[i];j<less[i]+equal[i];j++)
                rez[j]=a[i];

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
            for(int i=0;i<a.length-1;i=i+2){
                if(a[i]>a[i+1]){
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    b=true;
                }
            }
            for(int i=1;i<a.length-1;i=i+2){
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

    private static void qsMethod(int[] a,int l,int r){
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
        if(j>l) qsMethod(a,l,j);
        if(r>i) qsMethod(a,i,r);
    }

}
