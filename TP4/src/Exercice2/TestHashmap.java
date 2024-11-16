package Exercice2;

import java.util.HashMap;

public class TestHashmap {
    public static void main(String[] args) {
        HashMap<String, Double> qde = new HashMap<>();
        //1)
        qde.put("Ahmed elhkamsi", 13.0);
        qde.put("Malak jawhari", 15.0);
        qde.put("layla tindof", 10.0);
        qde.forEach((v,w)-> System.out.println(v+" : "+w));
        //2)
        System.out.println("la note avant la modification est :"+qde.get("layla tindof"));
        if(qde.get("layla tindof")<=18){
            qde.put("layla tindof",qde.get("layla tindof")+2);

        }
        else if(qde.get("layla tindof")==19){
            qde.put("layla tindof",qde.get("layla tindof")+2);
        }
        System.out.println("la note apres la modification est :"+qde.get("layla tindof"));
        System.out.println("le map apres la modification est :");
        qde.forEach((v,w)-> System.out.println(v+" : "+w));
        //3)
        qde.remove("layla tindof");
        System.out.println("le map apres la suppression est :");
        qde.forEach((v,w)-> System.out.println(v+" : "+w));
        //4)
        System.out.println("la taille du map.est : "+qde.size());
        //5)
        double s=0,min=20, max=0;
        for(String k : qde.keySet()){
            s+=qde.get(k);
            if(min>qde.get(k)){
                min=qde.get(k);
            }
            if(max<qde.get(k)){
                max=qde.get(k);
            }

        }
        System.out.println("le moyeen des notes est : "+s/qde.size());
        System.out.println("le max des notes est : "+max);
        System.out.println("le min des notes est : "+min);
        //6)
        int i=0;
        for(String k : qde.keySet()){
            if(qde.get(k)==20){
                System.out.println("la note 20 exist");
                break;
            }
            else i++;
        }
        if(i==qde.size())
            System.out.println("la note 20 n'exist pas");
        }
}
