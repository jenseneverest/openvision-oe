# bitbake fix:
```
export PATH=/location/openvision-oe/bitbake/bin:$PATH
export BBPATH=/location/openvision-oe/bitbake/bin
```
(Replace "location" with your path)

# Set build (Example: dm7020hd)
* cd build
* source env.source

# Clean kernel
* MACHINE=dm7020hd bitbake -c clean virtual/kernel

# Customize kerenl configuration
* MACHINE=dm7020hd bitbake -c menuconfig virtual/kernel

# Compile kernel
* MACHINE=dm7020hd bitbake -f -c compile virtual/kernel

More information: https://www.openembedded.org/wiki/Kernel_Building
