DESCRIPTION = "Firmware for the STxH205 CPU Flexible DMA engine (FDMA)"

LICENSE = "CLOSED"

SRC_URI = "file://lpm_fwSTxH205.elf"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 ${S}/lpm_fwSTxH205.elf ${D}${nonarch_base_libdir}/firmware
}

inherit allarch

# fix architecture mismatch QA error
INSANE_SKIP_${PN} = "arch"

do_compile() {
	:
}

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"
