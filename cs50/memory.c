#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    char *s = malloc(4*sizeof(char));
    printf("N: ");
    scanf("%s", s);
    printf("N: %s", s);
}