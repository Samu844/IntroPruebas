# Script para configurar JAVA_HOME y PATH temporalmente para este proyecto
# Úsalo desde PowerShell en la carpeta del proyecto con: . .\set-java-env.ps1 (dot-sourcing para aplicar en la sesión actual)

$javaHome = 'C:\Users\sloza\.jdks\ms-21.0.9'
$bin = Join-Path $javaHome 'bin'

# Establecer JAVA_HOME (temporal en la sesión)
$env:JAVA_HOME = $javaHome

# Normalizar PATH: eliminar entradas vacías y eliminar cualquier aparición previa del bin (case-insensitive)
$parts = ($env:Path).Split(';') | Where-Object { -not [string]::IsNullOrWhiteSpace($_) }
$filtered = $parts | Where-Object { -not ($_.Trim().Equals($bin, [System.StringComparison]::InvariantCultureIgnoreCase)) }

# Prepend the bin path
$env:Path = $bin + ';' + ($filtered -join ';')

Write-Host "JAVA_HOME set to: $env:JAVA_HOME"
Write-Host "(temporal en esta sesión) PATH updated (bin moved to start, duplicates removed)"
