public class StringStandard {

    public static void getStringStandard(String name) {

        String str = name.trim().toLowerCase().replaceAll("\s+", " ");
        String[] arr = str.split(" ");

        String result = "";

        //arr[i].charAt(index) trả về dữ liệu kiểu char, dùng valueOf để chuyển thành kiểu String
        for (int i = 0; i < arr.length; i++) {
            result += String.valueOf(arr[i].charAt(0)).toUpperCase() + arr[i].substring(1) + " ";
        }

        System.out.println("Tên sau khi đã chuẩn hóa: " + result.trim());
    }
}
