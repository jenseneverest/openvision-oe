SUMMARY = "Firmware files for RPi"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"
INSANE_SKIP_${PN} = "arch"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rpi-firmwares.tar.xz"

SRC_URI[md5sum] = "1e35ad2e5942ff821bbb7639c63e2820"
SRC_URI[sha256sum] = "9aa01918708c21d74402f3e718a5e22a639c5c91908bb570afb6cf912e0d58bd"

S = "${WORKDIR}/rpi-firmwares"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    cp -r  --preserve=mode,links ${S}/* ${D}${nonarch_base_libdir}/firmware/
}
