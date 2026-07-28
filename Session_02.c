// 1.Exercise_01
#include<stdio.h>

int main(){
    int a,b;
    prinf("Nhập vào 2 số nguyên: ");
    scanf("%d %d", &a, &b);
    if(a*b> 1000){
        printf("Tích hai số lơn hơn 1000");
    }else if(a*b<1000){
        printf("Tích hai số nhỏ hơn 1000");
    }else{
        printf("Tích hai số bằng 1000");
    }
    return 0;
}

// 2.Exercise_02
#include<stdio.h>
#include <stdio.h>

int main() {
    int a, b;
    printf("Nhập vào 2 số nguyên: ");
    scanf("%d %d", &a, &b);

    if (a - b == a) {
        printf("Hiệu số bằng giá trị: %d\n", a);
    } else if (a - b == b) {
        printf("Hiệu số bằng giá trị: %d\n", b);
    } else {
        printf("Hiệu số không bằng giá trị nào\n");
    }

    return 0;
}

// 3.Exercise_03
#include <stdio.h>
#include <math.h>

int main() {
    float salary, final_salary;
    char grade;
    int allowance;

    printf("Nhập vào mức lương: ");
    scanf("%f", &salary);
    
    printf("Nhập vào mức A, B hoặc O (Orthers): ");
    scanf(" %c", &grade);

    switch (grade) {
        case 'A':
        case 'a':
            allowance = 300;
            break;
        case 'B':
        case 'b':
            allowance = 200;
            break;
        default:
            allowance = 100;
            break;
    }

    final_salary = salary + allowance;
    printf("Phụ cấp: $%d\n", allowance);
    printf("Lương cuối tháng: $%.2f\n", final_salary);

    return 0;
}

// 4.Exercise_04
#include<stdio.h>

int main(){
    float marks;
    printf("Nhập vào điểm số của bạn: ");
    scanf("%f", &marks);
    if(marks > 75){
        printf("Bạn đạt loại A\n");
    }else if(75 >marks > 60){
        printf("Bạn đạt loại B\n");
    }else if(60 >marks > 45){
        printf("Bạn đạt loại C\n");
    }else if (45 >marks > 35){
        printf("Bạn đạt loại D\n");
    }else{
        printf("Bạn đạt loại E\n");
    }
    return 0;
}

// 5.Exercise_05
#include<stdio.h>

int main(){
    char letter;
    printf("Nhập vào một ký tự: ");
    scanf("%c", &letter);

    switch(letter){
        case 'B':
        case 'b':
            printf("Basic\n");
            break;
        case 'C':
        case 'c':
            printf("Cobol\n");
            break;
        case 'F':
        case 'f':
            printf("Fortan\n");
            break;
        case 'P':
        case 'p':
            printf("Pascal\n");
            break;
        case 'V':
        case 'v':
            printf("Visual Basic\n");
            break;
        default:
            printf("Không có ngôn ngữ lập trình nào bắt đầu bằng ký tự '%c'\n", letter);
    }
    return 0;
}

// 6.Exercise_06 
#include<stdio.h>
#include<math.h>

int main(){
    float a, b, c, denta, x1, x2;
    printf("Nhập vào 3 số thực: ");
    scanf("%f %f %f", &a, &b, &c);

    denta = b*b - 4*a*c;
    if(denta > 0){
        x1 =(-b + sqrt(denta)) / (2*a);
        x2 = (-b - sqrt(denta)) / (2*a);
        printf("Phương trình có 2 nghiệm phân biệt\n");
    }else if(denta == 0){
        x1 = x2 = -b / (2*a);
        printf("Phương trình có nghiệm kép\n");
    }else{
        printf("Phương trình vô nghiệm\n");
    }
    return 0;
}
