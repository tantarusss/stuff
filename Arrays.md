Übersicht zu Arrays und Lists (Vergleichen) 
# Array
fixed-size; Supported Primitives und Non-Primitives
```java
int[] arr = new int[3];
arr[0] = 1;
arr[1] = 2;
arr[2] = 3;

System.out.println(Arrays.toString(arr));
```

# ArrayList
non fixed-size (man kann Elemente hinzufügen und entfernen); Supported keine Primitives
Man greift mit Functions darauf zu (nicht mit \[index])

```java
from java.utils import ArrayList;

ArrayList<Integer> arrL = new ArrayList<>();
//== List<Integer> arrL = new ArrayList<>();

arrL.add(1);
arrL.add(2);
arrL.add(3);

System.out.println(arrL);
```
# Durch Array iteraten
## for Loop
Nutzen, wenn der Index relevant ist
```java
public static void main() {
		int numbers[] = {10, 20, 30, 40, 50}

		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
```
## for-each Loop
Nutzen, wenn der Index nicht relevant ist
```java
public static void main() {
		int numbers[] = {10, 20, 30, 40, 50};

		for (int element : numbers) {
			System.out.println(element);
		}
	}
```
## while Loop
```java
public static void main() {
	int numbers[] = {10, 20, 30, 40, 50};
	int i = 0;
	while(i < numbers.length) {
		System.out.println(numbers[i])
		i++;
	}
}
```
## Iterator
Kann universell bei jedem Collection object angewendet werden. Sowohl read als auch remove operations möglich.
## add()
Fügt der ArrayList ein Element hinzu
## remove()
Entfernt ein Element aus der ArrayList
## hasNext()
Checkt, ob ein weiteres Element in der ArrayList existiert (returnt bool)
## next()
Springt zum nächsten Element und returnt den Wert

```java
import java.util.ArrayList;  
import java.util.Iterator;  
  
public class MyIterator {  
    public static void main(String[] args) {  
        ArrayList<Integer> numbers = new ArrayList<>();  
        numbers.add(10);  
        numbers.add(50);  
        numbers.add(40);  
        numbers.add(30);  
        numbers.add(20);  
  
  
        Iterator<Integer> iter = numbers.iterator();  
  
        while (iter.hasNext()) {  
            Integer num = iter.next();  
            System.out.println(num);  
              
            if (num > 10) {  
                iter.remove();  
            }  
        }
        System.out.println(numbers);  
    }  
}
```


# App
App: Array mit Zahlen; Summe aus allen berechnen

Abwechselnd + und - im Array
index 0 als Grundwert und abwechselnd / *
