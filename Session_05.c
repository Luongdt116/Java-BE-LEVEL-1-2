// 1 Excercise 1
#include<stdio.h>
float calculate_peri(float r){
    float c = 2*3.14*r;
    printf("Chu vi hình tròn là: %f\n", c);
}

float calculate_area(float r){
    float s = 3.14*r*r;
    printf("Diện tích hình tròn là: %f\n", s);
}

int main(){
    float r;
    printf("Nhập vào bán kình hình tròn: ");
    scanf("%f", &r);

    printf("Chu vi hình tròn là: %f\n", calculate_peri(r));
    printf("Diện tích hình tròn là: %f\n", calculate_area(r));
    return 0;
}

// 2 Excercise 2
#include<stdio.h>

int factorial(int number){
    int result = 1;
    for (int i=1; i<=number; i++){
        result *=i;
    }
    return result;
}

int main(){
    int number;
    printf("Nhập vào một số nguyên cần tính giai thừa: ");
    scanf("%d", &number);
    printf("Giai thừa của %d là %d",number, factorial(number));
    return 0;
}


// 3. Excercise 3
#include<stdio.h>
#include<stdlib.h>

float inputMark(char subject[]){
    float mark;
    do{
        printf("Nhập điểm môn %s (0-10): ", subject);
        scanf("%f", &mark);
        if(mark < 0 || mark > 10){
            printf("Điểm không hợp lệ. Vui lòng nhập lại! \n");
        }
    }while (mark < 0 || mark > 10);
    return mark;
}

float calculateGPA(float db, float c, float oop, float java){
    float average_10 = (db + c + oop + java) / 4.0;
    float gpa_4 = (average_10/10.0)*4.0;
    return gpa_4;
}

void displayGPA(float gpa){
    printf("\n Điểm gpa của bạn là: %f \n", gpa);
}

void displayRank(float gpa){
    printf("\nXếp loại của bạn: ");
    if(gpa >= 3.6){
        printf("Xuất sắc\n");
    }else if(gpa >= 3.2 && gpa < 3.59){
        printf("Giỏi \n");
    }else if(gpa >= 2.5 && gpa < 3.19){
        printf("Khá \n");
    }else if(gpa >= 2.0 && gpa < 2.49){
        printf("Trung bình \n");
    }else if(gpa < 2.0){
        printf("Yếu \n");
    }
}

int main(){
    int choice;
    float db = 0, c = 0, oop = 0, java = 0;
    float gpa = 0.0;
    int isInputDone = 0;
    while(1){
        printf("=========================== \n");
        printf("1. Nhập điểm \n");
        printf("2. Xem GPA \n");
        printf("3. Xem xếp loại \n");
        printf("4. Thoát \n");
        printf("Chọn chức năng (1-4): ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            db = inputMark("Database");
            c = inputMark("C");
            oop = inputMark("OOP");
            java = inputMark("Java");

            gpa = calculateGPA(db, c, oop, java);
            isInputDone = 1;
            printf("Nhập điểm thành công.");
            break;
        case 2:
            if(isInputDone == 0){
                printf("Vui lòng nhập điểm của bạn \n");
            }else{
                displayGPA(gpa);
            }
            break;
        case 3:
            if(isInputDone == 0){
                printf("Vui lòng nhập điểm của bạn \n");
            }else{
                displayRank(gpa);
            }
            break;
        case 4:
            exit(0);
            break;
        
        default:
            break;
        }
    }  
    return 0; 
}
