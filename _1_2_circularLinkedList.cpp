#include <iostream>
#include <stdlib.h>
using namespace std;

struct Node {
    int data;
    struct Node* next;
};

void insertatfront(int data, struct Node*& head) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;

    if(head == NULL) {
        head = newNode;
        newNode->next = head;
    } else {
        struct Node* temp = head;

        while(temp->next != head) {
            temp = temp->next;
        }
        
        newNode->next = head;
        temp->next = newNode;
        head = newNode;
    }
}

void insertatlast(int data, struct Node* head) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;

    if(head == NULL) {
        head = newNode;
    } else {
        struct Node* temp = head;

        while(temp->next != head) {
            temp = temp->next;
        }
        
        newNode->next = head;
        temp->next = newNode;
    }
}

void insertAtAny(int data, struct Node* head, int pos) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    
    if(head == NULL) {
        head = newNode;
        newNode->next = head;
    } else {
        struct Node* temp = head;
        
        for(int i = 1; i < pos; i++) {
            temp = temp->next;
        }
        
        newNode->next = temp->next;
        temp->next = newNode;
    }
}

void printList(struct Node* head) {
    struct Node* temp = head;
    
    do {
        cout << temp->data;
        temp = temp->next;
    } while(temp != head);
}

void splitandprint(struct Node* head, struct Node*& first, struct Node*& second) {
    struct Node* curr = head;
    
    int size = 1;
    
    while(curr->next != head) {
        size++;
        curr = curr->next;
    }
    
    int halfsize = size/2;
    
    //first half
    curr = head;
    for(int i = 1; i <= halfsize; i++) {
        insertatlast(curr->data, first);
        curr = curr->next;
    }
    first->next = head;
    
    // second half
    struct Node* temp = curr;
    while(curr->next != temp) {
        insertatlast(curr->data, second);
        curr = curr->next;
    }
    second->next = temp;
    
    return;
}

void delatfront(struct Node* head) {
    struct Node* last = head;
    
    while(last->next != head) {
        last = last->next;
    }
    
    struct Node* temp = head;
    
    temp = temp->next;
    last->next = temp;
    head = temp;
    
    return;
}

void delatlast(struct Node* head) {
    struct Node* temp = head;
    
    
}

int main() {
    struct Node* head = NULL;

    insertatfront(1, head);
    insertatfront(2, head);
    insertatfront(3, head);
    
    insertAtAny(7, head, 2);
    insertatlast(9, head);
    insertatlast(10, head);

    printList(head);
}