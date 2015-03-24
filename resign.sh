rm -rf tmp
mkdir tmp
cp com.caimi.apk tmp/com.caimi.apk
cd tmp/
unzip com.caimi.apk
rm -rf META-INF
rm com.caimi.apk 
zip -r com.caimi.apk *
cd ..
mv tmp/com.caimi.apk com.caimi_debug.apk
jarsigner -digestalg SHA1 -sigalg MD5withRSA -keystore debug.keystore -storepass android -keypass android com.caimi_debug.apk androiddebugkey


rm -rf com.caimi
java -jar apktool.jar d com.caimi.apk
