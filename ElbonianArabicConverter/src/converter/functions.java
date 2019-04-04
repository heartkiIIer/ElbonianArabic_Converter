int mcount = 0;
        int ccount = 0;
        int xcount = 0;
        int icount = 0;
        int ncount = 0;
        int dcount = 0;
        int ycount = 0;
        int jcount = 0;

        boolean isValid = true;

        int count;
        for (int i = 0; i<number.length(); i++) {
            if(number.charAt(i) == 'M' || number.charAt(i) == 'C' || number.charAt(i) == 'X' || number.charAt(i) == 'I' || number.charAt(i) == 'N' || number.charAt(i) == 'D' || number.charAt(i) == 'Y' || number.charAt(i) == 'J') {
                if(number.charAt(i) == 'M'){
                    mcount++;
                    if (mcount >2 ){
                        isValid = false;
                    }
                }
                if(number.charAt(i) == 'C'){
                    ccount++;
                    if (ccount >2 ){
                        isValid = false;
                    }
                }
                if(number.charAt(i) == 'X'){
                    xcount++;
                    if (xcount >2 ){
                        isValid = false;
                    }
                }
                if(number.charAt(i) == 'I'){
                    icount++;
                    if icount >2 ){
                        isValid = false;
                    }
                }
                if(number.charAt(i) == 'N'){
                    ncount++;
                    if (ncount >3 ){
                        isValid = false;
                    }
                }
                if(number.charAt(i) == 'D'){
                    dcount++;
                    if (dcount >3 ){
                        isValid = false;
                    }
                }
                if(number.charAt(i) == 'Y'){
                    ycount++;
                    if (ycount >3 ){
                        isValid = false;
                    }
                }

                if(number.charAt(i) == 'J'){
                    jcount++;
                    if (xcount >3 ){
                        isValid = false;
                    }
                }
            }
            else{
                isValid = false; //One of the characers in the string is something other than MCXINDYJ
            }
        }

        for (int i = 0; i<number.length(); i++){
            if (number.charAt(i) == 'M' && ncount >= 3){
                isValid = false;
            }
            if (number.charAt(i) == 'C' && dcount >= 3){
                isValid = false;
            }
            if (number.charAt(i) == 'X' && ycount >= 3){
                isValid = false;
            }
            if (number.charAt(i) == 'I' && jcount >= 3){
                isValid = false;
            }
            if (number.charAt(i) == 'I'){
                if (number.charAt(i+1) != 'I' && i < number.length()){
                    isValid = false;
                }
            }
            if (number.charAt(i) == 'C'){
                if (number.charAt(i+1) == 'M' || number.charAt(i+1) == 'N' || number.charAt(i+1) == 'D'){
                    isValid = false;
                }
            }
        }


        if isValid{
            this.number = number; //It will only get here if the number is Valid for ALL of the elbonian rules
        }