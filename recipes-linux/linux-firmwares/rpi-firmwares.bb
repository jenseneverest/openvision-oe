SUMMARY = "Firmware files for RPi"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"
INSANE_SKIP_${PN} = "arch"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rpi-firmwares.tar.xz"

SRC_URI[md5sum] = "7b9708552092860a3c71f6471d390b13"
SRC_URI[sha256sum] = "7f5ec1f941726e85d189c92623120add55d6174d2f009f2517486c31d5002c7b"

S = "${WORKDIR}/rpi-firmwares"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    cp -r  --preserve=mode,links ${S} ${D}${nonarch_base_libdir}/firmware
}
