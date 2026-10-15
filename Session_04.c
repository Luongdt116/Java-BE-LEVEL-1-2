// 1/ Excercise 1
#include <stdio.h>

int main()
{
    int n;
    printf("Nhập vào độ dài của mảng: ");
    scanf("%d", &n);
    int arr[n];
    printf("Nhập vào từng phần tử của mảng: \n");
    for (int i = 0; i < n; i++)
    {
        printf("a[%d]: ", i);
        scanf("%d", &arr[i]);
    }

    int max = arr[0];
    for (int i = 1; i < n; i++)
    {
        if (max <= arr[i])
        {
            max = arr[i];
        }
    }
    printf("Giá trị lớn nhất của mảng là: %d\n", max);

    int min = arr[0];
    for (int i = 1; i < n; i++)
    {
        if (min >= arr[i])
        {
            min = arr[i];
        }
    }
    printf("Giá trị nhỏ nhất của mảng là: %d", min);

    return 0;
}

// 2. Excercise 2
#include<stdio.h>

int main(){
    int n;
    printf("Nhập vào độ dài của mảng: ");
    scanf("%d", &n);
    int arr[n];
    printf("Nhập vào từng phần tử của mảng: \n");
    for (int i = 0; i < n; i++)
    {
        printf("a[%d]: ", i);
        scanf("%d", &arr[i]);
    }

    int sum_odd = 0;
    for (int i = 0; i < n; i++)
    {
        if(arr[i] % 2 != 0)
        {
            sum_odd += arr[i];
        }
        
    }
    printf("Tổng các phần tử lẻ của mảng là: %d", sum_odd);
    return 0;
}

// 3. Excercise 3
#include<stdio.h>

int main(){
    int n,x;
    printf("Nhập vào độ dài của mảng: ");
    scanf("%d", &n);
    int arr[n];
    printf("Nhập vào từng phần tử của mảng: \n");
    for (int i = 0; i < n; i++)
    {
        printf("a[%d]: ", i);
        scanf("%d", &arr[i]);
    }

    int dem = 0;
    printf("Nhập vào phần tử cần đếm: ");
    scanf("%d", &x);
    for (int i = 0; i < n; i++)
    {
        if(arr[i] == x)
        {
            dem++;
        }
        
    }
    printf("Số lần xuất hiện của phần tử %d trong mảng là: %d", x, dem);
    return 0;
}

// 4. Excercise 4
#include<stdio.h>

int main(){
    int n;
    printf("Nhập vào độ dài của mảng: ");
    scanf("%d", &n);
    int arr[n];
    printf("Nhập vào từng phần tử của mảng: \n");
    for (int i = 0; i < n; i++)
    {
        printf("a[%d]: ", i);
        scanf("%d", &arr[i]);
    }

    int odd[n];
    int j = 0;
    for(int i=0; i<n; i++){
        if(arr[i] %3==0 || arr[i] %5==0){
            odd[j] = arr[i];
            j++;
        }
    }
    if(j==0){
        printf("Không có phần tử nào chia hết cho 3 hoặc 5 trong mảng");
    }else{
        printf("Các phần tử chia hết cho 3 hoặc 5 trong mảng là:\n");
        for(int i=0; i<j; i++){
            printf("%d ", odd[i]);
        }
    }
    return 0;
}

// 5. Excercise 5
#include<stdio.h>

int main(){
    int n;
    printf("Nhập vào độ dài của mảng: ");
    scanf("%d", &n);
    int arr[n];
    printf("Nhập vào từng phần tử của mảng: \n");
    for (int i = 0; i < n; i++)
    {
        printf("a[%d]: ", i);
        scanf("%d", &arr[i]);
    }

    int dem = 0;
    for(int i = 0; i<n; i++){
        if(arr[i] > 0){
            dem++;
        }
    }
    if(dem==0){
        printf("Không có phần tử dương trong mảng");
    }else{
        printf("Số lượng phần tử dương trong mảng là: %d", dem);
    }
    return 0;
}

// 6. Excercise 6
#include<stdio.h>

int main(){
    int n;
    printf("Nhập vào độ dài của mảng: ");
    scanf("%d", &n);
    int arr[n];
    printf("Nhập vào từng phần tử của mảng: \n");
    for (int i = 0; i < n; i++)
    {
        printf("a[%d]: ", i);
        scanf("%d", &arr[i]);
    }
    
    int dem = 0;
    for(int i = 0; i<n; i++){
        if(arr[i] %2 == 0){
            dem++;
        }
    }
    if(dem==0){
        printf("Đây là mảng lẻ");
    }else{
        printf("Mảng có phần tử chắn trong đó");
    }
    return 0;
}

// 7. Excercise 7
#include <stdio.h>

int main()
{
    int n;
    printf("Nhập vào độ dài của mảng: ");
    scanf("%d", &n);
    int arr[n];
    printf("Nhập vào từng phần tử của mảng: \n");
    for (int i = 0; i < n; i++)
    {
        printf("a[%d]: ", i);
        scanf("%d", &arr[i]);
    }

    int prime[n];
    int j = 0;
    for (int i = 0; i < n; i++)
    {
        int is_prime = 1;
        if (arr[i] < 2)
        {
            is_prime = 0;
        }
        else
        {
            for (int k = 2; k <= arr[i] / 2; k++)
            {
                if (arr[i] % k == 0)
                {
                    is_prime = 0;
                    break;
                }
            }
        }

        if (is_prime)
        {
            prime[j] = arr[i];
            j++;
        }
    }
    if (j == 0)
    {
        printf("Không có phần tử nào là số nguyên tố trong mảng");
    }
    else
    {
        printf("Các phần tử là số nguyên tố trong mảng là:\n");
        for (int i = 0; i < j; i++)
        {
            printf("%d ", prime[i]);
        }
    }
    return 0;
}

// 8. Excercise 8
#include <stdio.h>
#include <string.h>

int main() {
    char input[20];       
    int digits[10];      

    while (1) {
        printf("Nhập mã ISBN (nhập 0 để thoát): ");
        scanf("%s", input);

        if (strcmp(input, "0") == 0) {
            printf("Chương trình kết thúc!\n");
            break;
        }

        if (strlen(input) != 10) {
            printf("Đây không phải là mã ISBN hợp lệ (phải có đúng 10 chữ số).\n\n");
            continue;
        }

        // Chuyển đổi dữ liệu từ mảng ký tự sang mảng số nguyên
        for (int i = 0; i < 10; i++) {
            digits[i] = input[i] - '0';
        }

        int total_sum = 0;
        int weight = 10;

        // Tính tổng 9 phần tử đầu tiên trong mảng số nguyên nhân với trọng số
        for (int i = 0; i < 9; i++) {
            total_sum += digits[i] * weight;
            weight--; 
        }

        // Cộng thêm phần tử thứ 10 (chữ số kiểm tra ở vị trí index 9)
        total_sum += digits[9];

        // Kiểm tra điều kiện chia hết cho 11
        if (total_sum % 11 == 0) {
            printf("--- Trình kiểm tra mã ISBN ---\n");
            printf("Đây là một mã ISBN hợp lệ.\n\n");
        } else {
            printf("Đây không phải là mã ISBN hợp lệ.\n\n");
        }
    }

    return 0;
}
