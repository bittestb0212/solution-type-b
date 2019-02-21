package problem04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		try {
			new Main().start();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void start() throws IOException, ClassNotFoundException {
		int[] map = { 1, 1, 1, 1, 0, 0, 0, 0 };
		int challenge = 0;
		int retry = 0;
		int time = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int p = 0;
		int dice = 0;

		long start = System.currentTimeMillis();

		System.out.println("게임을 시작합니다.");
		label: while (true) {
			map = shuffle(map);
			for (int i = 0; i < map.length; i++) {
				if (map[i] == 1) {
					System.out.print("O");
				} else
					System.out.print("#");
			}
			retry++;

			while (true) {
				if (br.readLine().equals("")) {
					challenge++;
					dice = (int) (Math.random() * 4 + 1);
				}
				p += dice;
				if (p > map.length)
					break label;
				if (map[p - 1] == 0) {
					// 게임 하나 생성 및 저장
					System.out.println("주사위 " + dice + ". " + "위치 " + p + "." + "강물입니다. 다시 시작합니다.");
					p = 0;
					continue label;
				} else {
					System.out.println("주사위 " + dice + ". " + "위치 " + p + ".");
				}
			}
		}

		System.out.println("게임 끝");

		long end = System.currentTimeMillis(); // 프로그램이 끝나는 시점 계산
		time = (int) ((end - start) / 1000.0);
		Game game = new Game(challenge, retry, time);
		System.out.println(challenge);
		System.out.println(retry);
		System.out.println(time);

		FileOutputStream fis = new FileOutputStream("C:\\Users\\bit\\desktop\\Obj.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fis);

		oos.writeObject(game);

		FileInputStream fileStream = new FileInputStream("C:\\Users\\bit\\desktop\\Obj.ser");

		ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);

		Object object = objectInputStream.readObject();

		objectInputStream.close();

		System.out.println("읽어온 객체의 type->" + object.getClass());

		HashMap hashMap = (HashMap) object;

		Iterator<String> it = hashMap.keySet().iterator();

		while (it.hasNext()) {

			String key = it.next();

			String value = (String) hashMap.get(key);

			System.out.println(key + "->" + value);
		}

	}

	public static int[] shuffle(int[] arr) {
		for (int x = 0; x < arr.length; x++) {
			int i = (int) (Math.random() * arr.length);
			int j = (int) (Math.random() * arr.length);

			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}

		return arr;
	}

}
