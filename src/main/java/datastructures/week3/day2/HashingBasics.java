public Class HashingBasics{


    /**
        Hashing calculation :
        - every value is assigned with a uniquecode
        - to calculate this code , hashing perfoms 3times right shif(>>>) operator on '16'
        
        HashMap is designed based on Hashing calculation :
        - put(key, value) method internally calls putValue(hash(key), key, value)

        Hash Collision :
        - when 2 keys having same hashing value, this causes hash collision
        - so, on hashing value 3times rt shifting is performed
        - 

    
    
     */
}