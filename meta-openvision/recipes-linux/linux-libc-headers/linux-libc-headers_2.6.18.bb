require linux-libc-headers.inc

SRC_URI += " \
        file://mips-add-missing-headers.patch \
        file://mips-fix-ptrace-header.patch \
        file://mips-brcm-add-missing-syscalls.patch \
        file://dvb-api-2.6.18-5.3.patch \
        file://fix-linux-futex-h.patch \
        file://mips-fix-64bit-types.patch \
        file://linux-2.6.18-include-asm.patch \
        file://linux-2.6.18-include-linux.patch \
        file://linux-2.6.18-include-linux-add-missing-headers.patch \
        file://linux-2.6.18-dm-ioctl_h.patch \
        file://linux-2.6.18-rfkill.patch \
        file://ppp-over-l2tp.patch \
        file://ifpacket_linuxtypes.patch \
        file://pktsched_linuxtypes.patch \
        file://makefile_make3-8-2.patch \
	file://mips-utimensat.patch \
        file://mips-pps.patch \
	file://add_resolution_to_absinfo.patch \
	file://add_strcasecmp.patch \
	file://extra_ipv6_headers.patch \
	file://dm-ioctl-add-data-to-struct.patch \
	file://magic.h \
	file://string.h \
"
SRC_URI[md5sum] = "296a6d150d260144639c3664d127d174"
SRC_URI[sha256sum] = "c95280ff6c5d2a17788f7cc582d23ae8a9a7ba3f202ec6e4238eaadfce7c163d"

do_install_append() {
	# These two are provided by glibc, so don't ship them!
	rm -f ${D}${includedir}/scsi/scsi_ioctl.h ${D}${includedir}/scsi/sg.h
	# Install magic.h and string.h to satisfy some packages
	mkdir -p ${D}${includedir}/linux
	install -m 0644 ${WORKDIR}/magic.h ${D}${includedir}/linux
	install -m 0644 ${WORKDIR}/string.h ${D}${includedir}/linux
}
