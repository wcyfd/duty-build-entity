@echo off
for %%i in (*.proto) do protoc-3.0.2-windows-x86_64.exe --java_out=. %%i