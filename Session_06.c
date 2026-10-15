#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

void inputArray(int arr[], int *size){
    
    do{
        printf("Nhập vào số phần tử của mảng (tối đa 100): ");
        scanf("%d", size);
        if(*size < 1 || *size > 100){
            printf("Số phần tử không hợp lệ. Vui lòng nhập lại.\n");
        }
    }while(*size < 1 || *size > 100);

    printf("Nhập vào các phần tử của mảng:\n");
    for(int i = 0; i < *size; i++){
        printf("arr[%d]: ", i);
        scanf("%d", &arr[i]);
    }
    printf("Nhập dữ liệu thành công \n");
    
}

void outputArray(int arr[], int n){
    printf("Các phần tử của mảng là: ");
    for(int i = 0; i < n; i++){
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void sortDesc(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] < arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

bool checkArrOdd(int arr[], int n){
    int dem = 0;
    for(int i = 0; i < n; i++){
        if( arr[i] %2 == 0){
            dem++;
        }
    }
    if( dem == 0){
        return true;
    }else{
        return false;
    }
}

int countOccurrences(int arr[], int n, int value) {
    int count = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] == value) {
            count++;
        }
    }
    return count;
}

void displayPrime(int arr[], int n){
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
        printf("Các phần tử là số nguyên tố trong mảng là: ");
        for (int i = 0; i < j; i++)
        {
            printf("%d ", prime[i]);
        }
        printf("\n");
    }
}


int main(){
    int choice, n, isInput;
    int a[100];
    n = 0;
    isInput = 0;
    while(1){
        printf("======================\n");
        printf("1. Nhập mảng \n");
        printf("2. Hiển thị mảng đã nhập \n");
        printf("3. Sắp xếp mảng giảm dần \n");
        printf("4. Kiểm tra mảng có là mảng lẻ không? \n");
        printf("5. Tìm kiếm giá trị \n");
        printf("6. Hiển thị số nguyên tố trong mảng \n");
        printf("7. Thoát \n");
        printf("Nhập vào thao tác muốn thực hiện: ");
        scanf("%d", &choice);
        
        if (choice >= 2 && choice <= 6 && isInput == 0) {
            printf("\nLỗi: Mảng đang trống! Vui lòng chọn chức năng 1 để nhập mảng trước.\n");
            continue;
        }

        switch (choice)
        {
        case 1: 
            inputArray(a, &n);
            isInput = 1;
            break;
        case 2:
            outputArray(a,n);
            break;
        case 3:
            int tempArr[100];
            for(int i = 0; i < n; i++) {
                tempArr[i] = a[i];
            }
            
            sortDesc(tempArr, n);
            
            printf("Mảng sắp xếp theo thứ tự giảm dần là:\n");
            outputArray(tempArr, n);
            break;
        case 4:
            if(checkArrOdd(a,n)){
                printf("Đây là mảng lẻ \n");
            }else{
                printf("Mảng chứa cả phần tử chẵn \n");
            }
            break;
        case 5: {
            int x;
            printf("Nhập vào giá trị muốn tìm kiếm: ");
            scanf("%d", &x);
            
            int occurrences = countOccurrences(a, n, x);
            
            if (occurrences > 0) {
                printf("Giá trị %d xuất hiện %d lần trong mảng.\n", x, occurrences);
            } else {
                printf("Giá trị %d không tồn tại trong mảng.\n", x);
            }
            break;
        }
        case 6:
            displayPrime(a,n);
            break;
        case 7:
            exit(0);
            break;
        
        default:
            printf("Lựa chọn không hợp lệ ! \n");
            break;
        }
    }
    return 0;   
}
