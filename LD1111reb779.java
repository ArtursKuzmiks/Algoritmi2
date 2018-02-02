import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class LD1111reb779 {

    private static int Arr[];

    public static void main(String[] args) throws IOException{
        int met;
        int count;

        System.out.println("Arturs Kuzmiks 12.gr. 111REB779");

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("method: ");
            met = Integer.parseInt(br.readLine());

            if(met!=1 && met!=2) throw new IllegalArgumentException();

            System.out.print("count: ");
            count = Integer.parseInt(br.readLine());

            Arr=new int [count];
            System.out.println("items:");

            for(int i=0;i<count;i++)
                Arr[i]=Integer.parseInt(br.readLine());

        }catch (IllegalArgumentException e){
            System.out.println("input-output error");
            return;
        }
        switch (met){
            case 1: firstMethod(Arr);
            case 2: secondMethod(Arr);
        }

        System.out.println("sorted:");
        for (int i : Arr) System.out.print(i + "\t");
}
    private static void firstMethod(int[] a){

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
    private static void secondMethod(int[] a){

        Random rd = new Random();
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

}
