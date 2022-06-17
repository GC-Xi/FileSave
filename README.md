# FileSave
Save file to different path on Android


## Internal Storage
The internal storage is not accessible from outside the app.

dataDir - the root level of internal storage

filesDir - a directory called `files` inside dataDir, can be wiped by clear storage

cacheDir - a directory called `cache` inside dataDir, can be wiped by clear storage or clear cache



## External Storage
The external storage can be accessed by computer usb, or file manager if the file manager reads from disk directly.
The data here will be earsed if the app is uninstalled.

externalFilesDir - `Android/data/[package_name]/files`, can be wiped by clear storage

externalCacheDir - `Android/data/[package_name]/cache`, can be wiped by clear storage or clear cache
