// 1. Exercise 1
#include<stdio.h>

int main(){
    for(int i=100; i>=5; i-=5){
        printf("%d\n", i);
    }
    return 0;
}

// 2. Exercise 2
#include<stdio.h>

int main(){
    int num1, num2, start, end, sum ;
    printf("Nhập vào hai số nguyên: ");
    scanf("%d %d", &num1, &num2);

    if(num1 < num2){
        start = num1;
        end = num2;
    }else{
        start = num2;
        end = num1;
    }

    sum = 0;
    for(int i=start; i<=end; i++){
        if(i % 2 != 0){
            sum += i;
        }
    }
    printf("Tổng số lẻ từ '%d' đến '%d' là: %d\n", start, end, sum);
}

// 3. Exercise 3
#include<stdio.h>

int main(){
    int a,b;
    a=0;
    b=1;
    for(int i=1; i<10; i++){;
        printf("%d\n", b);
        int next = a + b;
        a = b;
        b = next;
    }
    return 0;
}

// 4. Exercise 4
#include<stdio.h>

int main(){
    int a;
    printf("Chọn hình 1 hoặc 2: ");
    scanf("%d", &a);
    switch(a){
        case 1:
            for(int i=1; i<=5; i++){
                for(int j=1; j<=i; j++){
                    printf("%d", j);
                }
                printf("\n");
            }
            break;
        case 2:
            for(int i=5; i>=1; i--){
                for(int j=1; j<=i; j++){
                    printf("%d", j);
                }
                printf("\n");
            }
            break;
        default:
            printf("Không có hình nào được chọn\n");
    }
    return 0;
}

// 5. Exercise 5
#include<stdio.h>

int main(){
    
    for(int i=7; i>=1; i--){
        for(int j=1; j<=i; j++){
            printf("*");
        }
        printf("\n");
    }

    return 0;
}

// 6. Exercise 6
#include<stdio.h>

int main(){
    int a;
    printf("Bảng cửu chương từ 2 đến 9: ");
    scanf("%d", &a);
    if (a < 2 || a > 9) {
        printf("Số nhập vào không hợp lệ. Vui lòng nhập số từ 2 đến 9.\n");
    } else {
        for(int i=1; i<=10; i++){
            printf("%d x %d = %d\n", a, i, a*i);
        }
    }
    return 0;
}

// 7.Exercise 7
#include<stdio.h>

int main(){
    int password, i;
    i=1;
    while (i<=3)
    {
        printf("Nhập vào mật khẩu: ");
        scanf("%d", &password);
        if(password == 12345){
            printf("Bạn đã nhập sai quá 3 lần, vui lòng thử lại sau\n");
        break;
        }else{
            printf("Nhập vào mật khẩu: ");
            scanf("%s", &password);
            if(password == 12345){
                printf("Đăng nhập thành công\n");
                break;
            }else{
                printf("Mật khẩu không đúng, vui lòng thử lại\n");
                i++;
            }
        }
    }
    if(i>3){
        printf("Bạn đã nhập sai quá 3 lần, vui lòng thử lại sau\n");
    }
    
    return 0;
}
