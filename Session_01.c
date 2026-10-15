// 1.Exercise_01
#include <stdio.h>

int main()
{
    float r,c,s;
    printf("Nhập vào bán kình hình tròn: ");
    scanf("%f: ", &r,"/n");
    c = 2*3.14*r;
    s = 3.14*r*r;
    printf("Chu vi hình tròn là: %f\n", c);
    printf("Diện tích hình tròn là: %f\n", s);
    return 0;
}

// 2.Exercise_02
#include<stdio.h>

int main()
{
    int age;
    float salary;
    printf("Nhập vào tuổi của bạn: ");
    scanf("%d", &age);
    printf("Nhập vào mức lương của bạn: ");
    scanf("%f", &salary);
    printf("Tuổi của bạn là: %d\n", age);
    printf("Mức lương của bạn là: %.2f\n", salary);
    return 0;
}

// 3.Exercise_03
#include <stdio.h>

int main() {
    float Basic_Salary;
    float DA, HRA = 150, TA = 120, Others = 450;
    float PF, IT, Net_Salary;

    printf("Nhập vào mức lương cơ bản của bạn: ");
    scanf("%f", &Basic_Salary);

    DA = 0.12 * Basic_Salary;
    PF = 0.14 * Basic_Salary;
    IT = 0.15 * Basic_Salary;
    Net_Salary = Basic_Salary + DA + HRA + TA + Others - (PF + IT);

    printf("Lương chính thức của bạn là: %.2f $\n", Net_Salary);
    return 0;
}

// 4.Exercise_04
#include<stdio.h>

int main(){
    int num, digit1, digit2, digit3, sum;
    printf("Nhập vào số nguyên có 3 chữ số: ");
    scanf("%d", &num);

    digit1= num/100;
    digit2= (num/10)%10;
    digit3= num%10;

    sum = digit1 + digit2 + digit3;
    printf("Tổng các chữ số của số %d là: %d\n", num, sum);
    return 0;
}

// 5.Exercise_05
#include<stdio.h>
#include<math.h>

int main(){
    // caculate two point (x1, y1) and (x2, y2)
    float x1, y1, x2, y2, distance;
    printf("Nhap vao toa do diem thu nhat (x1, y1): ");
    scanf("%f %f", &x1, &y1);
    printf("Nhap vao toa do diem thu hai (x2, y2): ");
    scanf("%f %f", &x2, &y2);
    distance = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    printf("Khoang cach giua hai diem la: %.2f\n", distance);
    return 0; 
}

// 6.Exercise_06
#include<stdio.h>
#include<math.h>

int main(){
    float a, b, c, s, area;
    printf("Nhap vao do dai 3 canh cua tam giac: ");
    scanf("%f %f %f", &a, &b, &c);
    s = (a + b + c) / 2;
    area = sqrt(s * (s - a) * (s - b) * (s - c));
    printf("Dien tich cua tam giac la: %.2f\n", area);
    return 0;
}
