#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//arbitrary length of 1 buffer for a line
#define MAX 1000 
#define USAGE(str) printf("%s", str); \
    for( i = 0; cmds[i]; i++){        \
        printf("%s", cmds[i]);        \
    }; //end 
    printf("\n")
    //string buffer for 1 line
char buff[MAX];

char * cmds[] ={
    "cd",
    "exec",
    "exit",
    "gcc",
    "ls",
    "man",
    "more",
    "mv",
    "rm",
    "pwd",
    "sh",
    "touch",
    "which",
    "$path"
};
//temp to hold currently scanned command
char cmd[MAX];
//main
int main (int argc, char * argv[]){
    //count a.out string on command line
    int i, count = 0;
    //nul terminated string
    buff[0] = 0;
    printf("hgm cli 2020\n");
    USAGE("Legal commands: ");
    printf("%d strings passed to argv[]\n", argc);
    while(--argc){
        count++;
        printf("next string is '%s\n", argv[count]);
        strcat(buff, argv[count]);
        strcat(buff, "; ");
        printf("new string is '%s'\n", buff);
    //end
    }
    if(count){
        i = 0;
        while(cmds[i]){
            if(strcmp(cmds[i], argv[1])){
                i++;
            } else{
                break;
            //end
            }
        //end    
        }
        if(cmds[i]){
            printf("cmd'%s' is a predefined.\n", cmds[i]);
        } else{
            USAGE("Not one of legal commands:");
        //end
        }
        system(buff);
    //end
    }
    return 0;
//end main
}
